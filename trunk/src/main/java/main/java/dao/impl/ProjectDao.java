package main.java.dao.impl;

import java.util.UUID;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.util.maven.example.Tables;
import org.jooq.util.maven.example.tables.records.ProjectRecord;

public class ProjectDao extends DaoBase {
	
	public String createProject(String projectName, UUID userID) {
		ProjectRecord project = create.newRecord(Tables.PROJECT);
		String projectID = UUID.randomUUID().toString();
		project.setIdproject(projectID);
		project.setProjectname(projectName);
		project.setUserid(userID.toString());
		project.store();
		return project.getIdproject();
	}
	
	public void deleteProject(String projectID) {
		ProjectRecord project = create.fetchOne(Tables.PROJECT, Tables.PROJECT.IDPROJECT.equal(projectID));
		
	}
	
	public void updateProject(String projectID, String name) {
		ProjectRecord project = create.fetchOne(Tables.PROJECT, Tables.PROJECT.IDPROJECT.equal(projectID));
		project.setProjectname(name);
		project.store();
	}
	
	public Result<Record> getAllProject(UUID userId) {
		Result<Record> result = create.select().from(org.jooq.util.maven.example.Tables.PROJECT).fetch();
		return result;
	}
}
