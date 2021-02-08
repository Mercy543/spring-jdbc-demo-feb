package com.simplilearn.training;

public class Student {
	
	private int stdId;
	private String stdName;
	private String stdLocation;
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdLocation() {
		return stdLocation;
	}
	public void setStdLocation(String stdLocation) {
		this.stdLocation = stdLocation;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdLocation=" + stdLocation + "]";
	}
	
	
	

}
