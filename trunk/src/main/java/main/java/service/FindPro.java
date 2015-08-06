package main.java.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface FindPro {
	public String getAllProject(@WebParam(name = "sessionID")String sessionID);
	
	public String createProject(@WebParam(name = "sessionID")String sessionID, @WebParam(name = "projectName")String projectName);
	
	public void searchProject(@WebParam(name = "keyword")String keyword);
	
	public void updateProject(@WebParam(name = "projectID")String projectID, @WebParam(name = "projectName")String projectName);
	
	public int createUser(@WebParam(name = "userName")String userName, @WebParam(name = "password")String password) throws Exception;
	
	public String login(@WebParam(name = "userName")String userName, @WebParam(name = "password")String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public String loginWithSessionID(@WebParam(name = "sessionID")String sessionID);
	
	public int logout(@WebParam(name = "sessionID")String sessionID);
}
