package main.java.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.internal.LinkedTreeMap;
import com.notenet.feedparser.entity.FeedInfo;
import com.notenet.feedparser.execute.FeedInfoIndexer;
import com.notenet.feedparser.execute.FeedSourceIndexer;
import com.notenet.feedparser.util.Constants;

//@Controller
public class FeedInfoController extends BasicController {
	FeedSourceIndexer feedSourceIndexer = new FeedSourceIndexer(Constants.ES_HOST_HTTP);
	FeedInfoIndexer feedInfoIndexer = new FeedInfoIndexer(Constants.ES_HOST_HTTP);
	
//	@RequestMapping(value = URL_FEEDINFO_DETAIL, method = RequestMethod.GET)
    public ModelAndView getFeedSourceDetail(@RequestParam(value = "id") String id) throws ClientProtocolException, IOException {
		ModelAndView mav = new ModelAndView(TILES_FEED_INFO_DETAIL);
        FeedInfo feedInfo = this.feedInfoIndexer.getFeedInfoFromIndex(id);
        mav.addObject("feedInfo", feedInfo);
        return mav;
    }
	
	private List<LinkedTreeMap<String, Object>> getAllFeedSource() throws ClientProtocolException, IOException {
		List<LinkedTreeMap<String, Object>> feedSourceList =  feedSourceIndexer.getAllFeedSource(10);
		System.out.println("Size of returned feedsource list: " + feedSourceList.size());
		return feedSourceList;
	}
}
