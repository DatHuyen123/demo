package com.dangvandat.dto.response;

import com.dangvandat.dto.BuildingDTO;

public class BuildingGetOne {
    private BuildingDTO buildingDTO;

    public BuildingGetOne() {
    }

    public BuildingDTO getBuildingDTO() {
        return buildingDTO;
    }

    public void setBuildingDTO(BuildingDTO buildingDTO) {
        this.buildingDTO = buildingDTO;
    }
}
