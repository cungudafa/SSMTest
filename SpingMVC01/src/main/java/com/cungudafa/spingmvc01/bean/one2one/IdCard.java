package com.cungudafa.spingmvc01.bean.one2one;

public class IdCard {
	private Integer idCardId;
	private String idCardNumber;
	/**
	 * 身份证属于某个人
	 */
	private Person person;
	
	public Integer getIdCardId() {
		return idCardId;
	}
	public void setIdCardId(Integer idCardId) {
		this.idCardId = idCardId;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
