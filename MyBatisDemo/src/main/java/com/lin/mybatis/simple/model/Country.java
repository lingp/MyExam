package com.lin.mybatis.simple.model;

public class Country {
	private Long id;
	private String country_name;
	private String country_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return country_name;
	}

	public void setCountryName(String countryName) {
		this.country_name = countryName;
	}

	public String getCountryCode() {
		return country_code;
	}

	public void setCountryCode(String countryCode) {
		this.country_code = countryCode;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country_name=" + country_name + ", country_code=" + country_code + "]";
	}
	
	
}
