package com.dangvandat.enums;

public enum BuildingType {
	TANG_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    NOI_THAT("Nội Thất");

    private String value;

    BuildingType(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}    
}
