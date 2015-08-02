package main.java.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import main.java.form.AddTagForm;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.internal.LinkedTreeMap;
import com.notenet.feedparser.entity.FeedSource;
import com.notenet.feedparser.execute.FeedInfoIndexer;
import com.notenet.feedparser.execute.FeedSourceIndexer;
import com.notenet.feedparser.util.Constants;

//@Controller
public class FeedSourceController extends BasicController {
	FeedSourceIndexer feedSourceIndexer = new FeedSourceIndexer(Constants.ES_HOST_HTTP);
	FeedInfoIndexer feedInfoIndexer = new FeedInfoIndexer(Constants.ES_HOST_HTTP);
	
//	@RequestMapping(value = URL_FEEDSOURCE, method = RequestMethod.GET)
    public ModelAndView getFeedSource() throws ClientProtocolException, IOException {
        ModelAndView mav = new ModelAndView(URL_FEEDSOURCE);
        List<LinkedTreeMap<String, Object>> result = this.getAllFeedSource();
        mav.addObject("feedSourceList", result);
        return mav;
    }
	
//	@RequestMapping(value = URL_FEEDSOURCE_DETAIL, method = RequestMethod.GET)
	public ModelAndView getFeedSourceDetail(@RequestParam(value = "id") String id) throws ClientProtocolException, IOException {
		
		ModelAndView mav = new ModelAndView(URL_FEEDSOURCE_DETAIL);
        FeedSource feedSource = this.feedSourceIndexer.getFeedSourceFromIndex(id);

        mav.addObject("feedSource", feedSource);
        mav.addObject("addTagForm", new AddTagForm());
        System.out.println("get feedSource detail and return");
        // get all feed of the feedsource
        return mav;
    }
	
//	@RequestMapping(value = URL_DELETE_TAG, method = RequestMethod.GET)
	public ModelAndView deleteTag(@RequestParam(value = "id") String id, @RequestParam(value="op") String op, @RequestParam(value="tag") String tag) throws ClientProtocolException, IOException {
		String id_encoded = URLEncoder.encode(id, "UTF-8");
		this.feedSourceIndexer.deleteTag(id_encoded, "tags", tag);
		
		return new ModelAndView(new RedirectView(URL_FEEDSOURCE_DETAIL + "?id=" + id_encoded, true, false, true));
    }
	
//	@RequestMapping(value = URL_FEEDSOURCE_DETAIL, method = RequestMethod.POST)
	public ModelAndView  addTag(@ModelAttribute(ADDTAG_FORM) AddTagForm addTagForm, @RequestParam(value = "id") String id) throws ClientProtocolException, IOException {
		String id_encoded = URLEncoder.encode(id, "UTF-8");
		String newTagName = addTagForm.getTagname();
		this.feedSourceIndexer.addTag(id_encoded, "tags", newTagName);
		
        return new ModelAndView(new RedirectView(URL_FEEDSOURCE_DETAIL + "?id=" + id_encoded, true, false, true));
    }
	
	private List<LinkedTreeMap<String, Object>> getAllFeedSource() throws ClientProtocolException, IOException {
		List<LinkedTreeMap<String, Object>> feedSourceList =  feedSourceIndexer.getAllFeedSource(10);
		System.out.println("Size of returned feedsource list: " + feedSourceList.size());
		return feedSourceList;
	}
}
