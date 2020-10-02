package com.dangvandat.repository;

import com.dangvandat.entity.RentArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface RentAreaRepository extends JpaRepository<RentArea , Long> {
    List<RentArea> findRentAreaByBuildingId(Long buildingId);
    void deleteRentAreaByBuildingId(Long buildingId);
}
