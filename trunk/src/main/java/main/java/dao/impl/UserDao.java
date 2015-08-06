package main.java.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import main.java.utils.EncryptionHelper;

import org.apache.commons.lang.StringUtils;
import org.jooq.util.maven.example.Tables;
import org.jooq.util.maven.example.tables.records.UserRecord;


public class UserDao extends DaoBase {
	EncryptionHelper helper = new EncryptionHelper();
	
	public String login(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println("User: " + userName + " try to login.");
		String encPassword = helper.encrypt(password);
		UserRecord user = create.fetchOne(Tables.USER, Tables.USER.USERNAME
				.equal(userName).and(Tables.USER.PASSWORD.equal(encPassword)));
		if (user != null) {
			String sessionID = UUID.randomUUID().toString();
			user.setSessionid(sessionID);
			user.update();
			System.out.println("User: " + userName + " login succeeded.");
			return sessionID;
		} else {
			System.out.println("User: " + userName + " login failed.");
			return "";
		}
	}
	
	public String login(String sessionID) {
		System.out.println("User: " + sessionID + " try to login.");
		UserRecord user = create.fetchAny(Tables.USER, Tables.USER.SESSIONID
				.equal(sessionID));
		if (user != null) {	
			System.out.println("User: " + user.getUsername() + " login succeeded.");
			return sessionID;
		} else {
			System.out.println("User: " + sessionID + " login failed.");
			return "";
		}
	}
	
	public int logout(String sessionID) {
		System.out.println("User: " + sessionID + " try to logout.");
		UserRecord user = create.fetchAny(Tables.USER, Tables.USER.SESSIONID
				.equal(sessionID));
		if (user != null) {	
			System.out.println("User: " + user.getUsername() + " logout succeeded.");
			user.setSessionid(null);
			return user.update();
		} else {
			System.out.println("User: " + sessionID + " login failed.");
			return -1;
		}
	}
	
	public UUID getUserIDBySessionID(String sessionID) {
		UserRecord user = create.fetchAny(Tables.USER, Tables.USER.SESSIONID
				.equal(sessionID));
		if (user != null) {	
			System.out.println("User: " + user.getUsername() + " logout succeeded.");
			return UUID.fromString(user.getIduser());
		} else {
			return null;
		}
	}
	
	public int createUser(String userName, String password) throws Exception {
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			String encPassword = helper.encrypt(password);
			String userID = UUID.randomUUID().toString();
			UserRecord user = create.newRecord(Tables.USER);
			user.setIduser(userID);
			user.setUsername(userName);
			user.setPassword(encPassword);
			int result = user.store();
			return result;
		} else {
			throw new Exception("Invalid user name or password");
		}
	}
}
