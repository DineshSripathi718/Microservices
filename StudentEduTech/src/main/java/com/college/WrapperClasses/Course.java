package com.college.WrapperClasses;

public class Course {
	private Integer cId;
	private String cName;
	private String cType;
	private Integer cDuration;
	private Double cFee;
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	public Integer getcDuration() {
		return cDuration;
	}
	public void setcDuration(Integer cDuration) {
		this.cDuration = cDuration;
	}
	public Double getcFee() {
		return cFee;
	}
	public void setcFee(Double cFee) {
		this.cFee = cFee;
	}
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cType=" + cType + ", cDuration=" + cDuration + ", cFee="
				+ cFee + "]";
	}
	
}
