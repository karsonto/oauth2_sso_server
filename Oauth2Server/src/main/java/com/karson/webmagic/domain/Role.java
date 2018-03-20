package com.karson.webmagic.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Role implements Serializable{
	@Id
	private String id;
	private String rolename;
	private String uri;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", uri=" + uri + ", description=" + description + "]";
	}

	
}
