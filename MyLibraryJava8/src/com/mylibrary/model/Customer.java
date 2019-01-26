package com.mylibrary.model;

public class Customer {

	private Integer cutomerId;
	private String name;
	private String address;
	public Customer(Integer cutomerId, String name, String address) {
		super();
		this.cutomerId = cutomerId;
		this.name = name;
		this.address = address;
	}
	public Integer getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(Integer cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "cutomerId=" + cutomerId + ", name=" + name + ", address=" + address ;
	}
	
	
}
