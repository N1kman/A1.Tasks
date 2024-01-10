package com.hil.task3.entity;

public class Posting {
	private long mat_doc;
	private int item;
	private String doc_date;
	private String pstng_date;
	private String description;
	private int quantity;
	private String bun;
	private float amount_LC;
	private String crcy;
	private String username;
	private boolean authorized_delivery;
	
	public Posting() {
		
	}
	
	public Posting(long mat_doc, int item, String doc_date, String pstng_date, String description, int quantity,
			String bUn, float amount_LC, String crcy, String username) {
		this.mat_doc = mat_doc;
		this.item = item;
		this.doc_date = doc_date;
		this.pstng_date = pstng_date;
		this.description = description;
		this.quantity = quantity;
		this.bun = bUn;
		this.amount_LC = amount_LC;
		this.crcy = crcy;
		this.username = username;
	}
	
	public long getMat_doc() {
		return mat_doc;
	}
	public void setMat_doc(long mat_doc) {
		this.mat_doc = mat_doc;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public String getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPstng_date() {
		return pstng_date;
	}
	public void setPstng_date(String pstng_date) {
		this.pstng_date = pstng_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBun() {
		return bun;
	}
	public void setBun(String bun) {
		this.bun = bun;
	}
	public String getCrcy() {
		return crcy;
	}
	public void setCrcy(String crcy) {
		this.crcy = crcy;
	}
	public float getAmount_LC() {
		return amount_LC;
	}
	public void setAmount_LC(float amount_LC) {
		this.amount_LC = amount_LC;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAuthorized_delivery() {
		return authorized_delivery;
	}

	public void setAuthorized_delivery(boolean authorized_delivery) {
		this.authorized_delivery = authorized_delivery;
	}
}
