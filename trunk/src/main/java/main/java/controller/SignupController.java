package main.java.controller;

import main.java.form.SignupForm;
import main.java.model.User;
import main.java.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController extends BasicController {
	@Autowired
    private IUserService userService;
	
	@RequestMapping(value = URL_SIGNUP, method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView(TILES_SIGNUP);
        return mav;
    }
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
    public ModelAndView signupGet(@ModelAttribute(SIGNUP_FORM) SignupForm signupForm) {
		String username = signupForm.getUsername();
		String password = signupForm.getPassword();
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		userService.addUser(user);
		
        ModelAndView mav = new ModelAndView(TILES_FIRST_PAGE);
        
        //List<Company> company = companyService.listCompany();
        
        //List<Employee> employee = employeeService.listEmployeeForCompany(company.get(1));
        
        //mav.addObject("company", company);
        //mav.addObject("employee", employee);
        //mav.addObject("message", message);
        
        return mav;
    }
}
