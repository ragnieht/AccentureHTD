package com.projectcars.model;

public class CustomerCars {
	private String username;
	private String carName;
	private String carType;
	private String carModel;
	private String carReg;
	private String serviceReq;
	private String status;
	
	public CustomerCars(String username, String carName, String carType, String carModel, String carReg,
			String serviceReq, String status) {
		super();
		this.username = username;
		this.carName = carName;
		this.carType = carType;
		this.carModel = carModel;
		this.carReg = carReg;
		this.serviceReq = serviceReq;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarReg() {
		return carReg;
	}

	public void setCarReg(String carReg) {
		this.carReg = carReg;
	}

	public String getServiceReq() {
		return serviceReq;
	}

	public void setServiceReq(String serviceReq) {
		this.serviceReq = serviceReq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
