package com.college.WrapperClasses;

import org.springframework.stereotype.Component;

@Component
public class StudentWrapper {
	private Integer sId;
	private String sName;
	private String sEmail;
	private Long sPhone;
	private String cName;
	private String cType;
	private Integer cDuration;
	private Double cFee;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public Long getsPhone() {
		return sPhone;
	}
	public void setsPhone(Long sPhone) {
		this.sPhone = sPhone;
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
		return "StudentWrapper [sId=" + sId + ", sName=" + sName + ", sEmail=" + sEmail + ", sPhone=" + sPhone
				+ ", cName=" + cName + ", cType=" + cType + ", cDuration=" + cDuration + ", cFee=" + cFee + "]";
	}
	
	
}
