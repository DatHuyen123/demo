package com.dangvandat.util;

import com.dangvandat.enums.BuildingType;
import com.dangvandat.enums.District;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DataUtil {
    public static Map<String , String> getBuildingType(){
        Map<String , String> results = new HashMap<>();
        Stream.of(BuildingType.values()).forEach(item -> {
            results.put(item.name() , item.getValue());
        });
        return results;
    }

    public static Map<String , String> getDistrict(){
        Map<String , String> results = new HashMap<>();
        Stream.of(District.values()).forEach(item ->{
            results.put(item.name() , item.getValue());
        });
        return results;
    }
}
