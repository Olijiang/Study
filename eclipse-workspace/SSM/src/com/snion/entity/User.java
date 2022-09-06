package com.snion.entity;

public class User {
	
	private int id;
	private int u_id;
	private String identity_type;
	private String identity;
	private String credential;
	private int status_code;
	
	public User(int id, int u_id, String identity_type, String identity, String credential, int status_code) {
		super();
		this.id = id;
		this.u_id = u_id;
		this.identity_type = identity_type;
		this.identity = identity;
		this.credential = credential;
		this.status_code = status_code;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getIdentity_type() {
		return identity_type;
	}
	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", u_id=" + u_id + ", identity_type=" + identity_type + ", identity=" + identity
				+ ", credential=" + credential + ", status_code=" + status_code + "]";
	}

	

}