package com.sklsongkiat.scraping.model;

public class ReportConfirmModel {
	
	private String mDate;
	private String mSummery;
	private String mNew;
	private String mComa;
	private String mDied;
	private String mGoHome;

	public ReportConfirmModel() {}
	
	public void setDate(String mDate) {
		this.mDate = mDate;
	}
	
	public String getDate() {
		return this.mDate;
	}
	
	public void setSummery(String mSummery) {
		this.mSummery = mSummery;
	}
	
	public String getSummery() {
		return this.mSummery;
	}
	
	public void setNew(String mNew) {
		this.mNew = mNew;
	}
	
	public String getNew() {
		return this.mNew;
	}
	
	public void setComa(String mComa) {
		this.mComa = mComa;
	}
	
	public String getComa() {
		return this.mComa;
	}
	
	public void setDied(String mDied) {
		this.mDied = mDied;
	}
	
	public String getDied() {
		return mDied;
	}
	
	public void setGoHome(String mGoHome) {
		this.mGoHome = mGoHome;
	}
	
	public String getGoHome() {
		return this.mGoHome;
	}
}
