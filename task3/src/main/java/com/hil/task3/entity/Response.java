package com.hil.task3.entity;

import java.util.ArrayList;

public class Response {
	ArrayList<Login> listLogin;
	ArrayList<Posting> listPosting;
	
	public Response(ArrayList<Login> listLogin, ArrayList<Posting> listPosting) {
		this.listLogin = listLogin;
		this.listPosting = listPosting;
	}
	
	public ArrayList<Login> getListLogin() {
		return listLogin;
	}

	public void setListLogin(ArrayList<Login> listLogin) {
		this.listLogin = listLogin;
	}

	public ArrayList<Posting> getListPosting() {
		return listPosting;
	}

	public void setListPosting(ArrayList<Posting> listPosting) {
		this.listPosting = listPosting;
	}
}
