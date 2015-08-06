package main.java.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.UUID;

import main.java.dao.impl.ProjectDao;
import main.java.dao.impl.UserDao;
import main.java.service.FindPro;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.util.maven.example.tables.records.ProjectRecord;

public class FindProImpl implements FindPro {

	ProjectDao projectDao = new ProjectDao();
	UserDao userDao = new UserDao();
	
	public FindProImpl() throws SQLException, ClassNotFoundException {
		userDao.initialize();
		projectDao.initialize();
	}

	@Override
	public String getAllProject(String sessionID) {
		String result = "";
		UUID userID = this.userDao.getUserIDBySessionID(sessionID);
		if(userID!=null) {
			Result<Record> projectList = projectDao.getAllProject(userID);
			for (Record record : projectList) {
				// Perform actions on BookRecords depending on some conditions
				ProjectRecord project = (ProjectRecord)record;
				result += project.getProjectname();
			}
		}
		return result;
	}
	
	@Override
	public String createProject(String sessionID, String projectName) {
		// retrieve userID from sessionID
		UUID userID = this.userDao.getUserIDBySessionID(sessionID);
		if (userID!=null) {
			System.out.println("User: " + String.valueOf(userID) + " try to create new porject with name " + projectName);
			return this.projectDao.createProject(projectName, userID);
		} else {
			System.out.println("User: " + String.valueOf(userID) + " try to create new porject with name " + projectName);
		}
		return null;
	}
	
	@Override
	public void searchProject(String keyword) {
		//TODO
	}
	
	@Override
	public void updateProject(String projectID, String projectName) {
		//TODO
	}

	@Override
	public int createUser(String userName, String password) throws Exception {
		System.out.println(String.format("Create user with %s, %s", userName, password));
		return this.userDao.createUser(userName, password);
	}

	@Override
	public String login(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return this.userDao.login(userName, password);
	}

	@Override
	public String loginWithSessionID(String sessionID) {
		return this.userDao.login(sessionID);
	}

	@Override
	public int logout(String sessionID) {
		return this.userDao.logout(sessionID);
	}

}
