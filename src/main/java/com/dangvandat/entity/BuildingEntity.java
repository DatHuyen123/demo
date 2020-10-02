package com.dangvandat.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Embeddable

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "numberofbasement")
	private Integer numberOfBasement;

	@Column(name = "buildingarea")
	private Integer buildingArea;

	@Column(name = "district")
	private String district;

	@Column(name = "ward")
	private String ward;

	@Column(name = "street")
	private String street;

	@Column(name = "structure")
	private String structure;

	@Column(name = "costrent")
	private Integer costRent;

	@Column(name = "cosdescription")
	private String cosDescription;

	@Column(name = "servicecost")
	private String serviceCost;

	@Column(name = "carcost")
	private String carCost;

	@Column(name = "motobikecost")
	private String motobikeCost;

	@Column(name = "overtimecost")
	private String overtimeCost;

	@Column(name = "electtricost")
	private String electtriCost;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "timerent")
	private String timeRent;

	@Column(name = "timedecorater")
	private String timeDecorater;

	@Column(name = "timecontract")
	private String timeContract;

	@Column(name = "managername")
	private String managerName;

	@Column(name = "managerphone")
	private String managerPhone;

	@Column(name = "type")
	private String type;

	@Column(name = "levelbuilding")
	private String levelBuilding;

	@Column(name = "direction")
	private String direction;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "assignmentstaff" , joinColumns = @JoinColumn(name = "buildingid") ,
			inverseJoinColumns = @JoinColumn(name = "staffid"))
	private List<UserEntity> staffs = new ArrayList<>();

	@OneToMany(mappedBy = "building" , fetch = FetchType.LAZY)
	private List<RentArea>  rentAreas = new ArrayList<>();

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
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}
	public String getDistrictId() {
		return district;
	}
	public void setDistrictId(String districtId) {
		this.district = districtId;
	}
	public String getCosdeScription() {
		return cosDescription;
	}
	public void setCosdeScription(String cosdeScription) {
		this.cosDescription = cosdeScription;
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
	public void setType(String buildingType) {
		this.type = buildingType;
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
	public Integer getCostRent() {
		return costRent;
	}
	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}
	public String getCosDescription() {
		return cosDescription;
	}
	public void setCosDescription(String cosDescription) {
		this.cosDescription = cosDescription;
	}
	public List<UserEntity> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<UserEntity> staffs) {
		this.staffs = staffs;
	}
	public List<RentArea> getRentAreas() {
		return rentAreas;
	}
	public void setRentAreas(List<RentArea> rentAreas) {
		this.rentAreas = rentAreas;
	}
}
