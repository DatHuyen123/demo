package com.dangvandat.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO>{
	private String name;
    private String ward;
    private String street;
    private String structure;
    private String numberOfBasement;
    private String buildingArea;
    private String district;
    private String direction;
    private String levelBuilding;
    private Integer costRent;
    private String cosDescription;
    private String serviceCost;
    private String carCost;
    private String motobikeCost;
    private String overtimeCost;
    private String electtriCost;
    private String deposit;
    private String payment;
    private String timeRent;
    private String timeDecorater;
    private String timeContract;
    private String managerName;
    private String managerPhone;
    private String type;
    private String address;
    private String rentArea;

    private String cosTrentFrom;
    private String cosTrentTo;
    private String areaRentFrom;
    private String areaRentTo;
    private String[] buildingTypes = new String[]{};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
    public String getNumberOfBasement() {
        return numberOfBasement;
    }
    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }
    public String getDistrictId() {
		return district;
	}
	public void setDistrictId(String district) {
		this.district = district;
	}
	public String getCosDescription() {
		return cosDescription;
	}
	public void setCosDescription(String cosDescription) {
		this.cosDescription = cosDescription;
	}
	public String getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getCarCost() {
		return carCost;
	}
	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}
	public String getMotobikeCost() {
		return motobikeCost;
	}
	public void setMotobikeCost(String motobikeCost) {
		this.motobikeCost = motobikeCost;
	}
	public String getOvertimeCost() {
		return overtimeCost;
	}
	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}
	public String getElecttriCost() {
		return electtriCost;
	}
	public void setElecttriCost(String electtriCost) {
		this.electtriCost = electtriCost;
	}
	public String getDeposit() {
        return deposit;
    }
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getTimeRent() {
		return timeRent;
	}
	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}
	public String getTimeDecorater() {
		return timeDecorater;
	}
	public String getTimeContract() {
		return timeContract;
	}
	public void setTimeDecorater(String timeDecorater) {
		this.timeDecorater = timeDecorater;
	}
	public void setTimeContract(String timeContract) {
		this.timeContract = timeContract;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
    public String getDistrict() {
        return district;
    }
    public String getDirection() {
        return direction;
    }
    public String getLevelBuilding() {
        return levelBuilding;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void setLevelBuilding(String levelBuilding) {
        this.levelBuilding = levelBuilding;
    }
    public String getCosTrentFrom() {
        return cosTrentFrom;
    }
    public String getCosTrentTo() {
        return cosTrentTo;
    }
    public void setCosTrentFrom(String cosTrentFrom) {
        this.cosTrentFrom = cosTrentFrom;
    }
    public void setCosTrentTo(String cosTrentTo) {
        this.cosTrentTo = cosTrentTo;
    }
    public String getAreaRentFrom() {
        return areaRentFrom;
    }
    public String getAreaRentTo() {
        return areaRentTo;
    }
    public void setAreaRentFrom(String areaRentFrom) {
        this.areaRentFrom = areaRentFrom;
    }
    public void setAreaRentTo(String areaRentTo) {
        this.areaRentTo = areaRentTo;
    }
    public Integer getCostRent() {
        return costRent;
    }
    public void setCostRent(Integer costRent) {
        this.costRent = costRent;
    }
    public String getAddress() {
        return this.street + "," + this.ward;
    }
    public String getRentArea() {
        return rentArea;
    }
    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }
    public String getBuildingArea() {
        return buildingArea;
    }
    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

}
