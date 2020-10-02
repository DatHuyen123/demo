package com.dangvandat.builder;

public class BuildingSearchBuilder {

    private String name;
    private String ward;
    private String street;
    private String numberOfBasement;
    private String buildingArea;
    private String district;
    private String managerName;
    private String managerPhone;
    private String staffId;

    private String costRentFrom;
    private String costRentTo;
    private String areaRentFrom;
    private String areaRentTo;
    private String[] buildingTypes = new String[]{};

    public String getName() {
        return name;
    }
    public String getWard() {
        return ward;
    }
    public String getStreet() {
        return street;
    }
    public String getAreaRentFrom() {
        return areaRentFrom;
    }
    public String getAreaRentTo() {
        return areaRentTo;
    }
    public String[] getBuildingTypes() {
        return buildingTypes;
    }
    public String getNumberOfBasement() {
        return numberOfBasement;
    }
    public String getDistrict() {
        return district;
    }
    public String getCostRentFrom() {
        return costRentFrom;
    }
    public String getCostRentTo() {
        return costRentTo;
    }
    public String getBuildingArea() {
        return buildingArea;
    }
    public String getManagerName() {
        return managerName;
    }
    public String getManagerPhone() {
        return managerPhone;
    }
    public String getStaffId() {
        return staffId;
    }

    public BuildingSearchBuilder(builder builder){
        this.name = builder.name;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.buildingArea = builder.buildingArea;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.district = builder.district;
        this.costRentFrom = builder.costRentFrom;
        this.costRentTo = builder.costRentTo;
        this.areaRentFrom = builder.areaRentFrom;
        this.areaRentTo = builder.areaRentTo;
        this.buildingTypes = builder.buildingTypes;
        this.staffId = builder.staffId;
    }

    public static class builder{

        private String name;
        private String ward;
        private String street;
        private String numberOfBasement;
        private String district;
        private String managerName;
        private String managerPhone;
        private String staffId;

        private String buildingArea;
        private String costRentFrom;
        private String costRentTo;
        private String areaRentFrom;
        private String areaRentTo;
        private String[] buildingTypes = new String[]{};

        public builder setName(String name) {
            this.name = name;
            return this;
        }
        public builder setWard(String ward) {
            this.ward = ward;
            return this;
        }
        public builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public builder setAreaRentFrom(String areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }
        public builder setAreaRentTo(String areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }
        public builder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }
        public builder setNumberOfBasement(String numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }
        public builder setDistrict(String district) {
            this.district = district;
            return this;
        }
        public builder setBuildingArea(String buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }
        public builder setCostRentFrom(String costRentFrom) {
            this.costRentFrom = costRentFrom;
            return this;
        }
        public builder setCostRentTo(String costRentTo) {
            this.costRentTo = costRentTo;
            return this;
        }
        public builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }
        public builder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }

        public builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingSearchBuilder builder(){
            return new BuildingSearchBuilder(this);
        }

    }

}
