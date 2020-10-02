package com.dangvandat.api;

import com.dangvandat.builder.BuildingSearchBuilder;
import com.dangvandat.contant.SystemContant;
import com.dangvandat.dto.BuildingDTO;
import com.dangvandat.dto.response.BuildingGetOne;
import com.dangvandat.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService buildingService;

    @PostMapping
    public BuildingDTO createBuilding(HttpServletRequest request , @RequestBody BuildingDTO newBuilding){
        request.getHeader(SystemContant.HEADER_STRING);
        return buildingService.save(newBuilding);
    }

    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody BuildingDTO newBuilding){
//        BuildingDTO buildingDTO = new BuildingDTO();
//        Field[] fields = buildingDTO.getClass().getDeclaredFields();
//        List<String> nameField = new ArrayList<>();
//        for(Field field : fields){
//            nameField.add(field.getName());
//        }
//        System.out.println(nameField);
        return buildingService.update(newBuilding , newBuilding.getId());
    }

    @GetMapping
    public List<BuildingDTO> showBuilding(@RequestParam Map<String , String> model ,
                                          @RequestParam String[] buildingTypes){
        BuildingSearchBuilder builder = initBuildingBuider(model , buildingTypes);
        Pageable pageable = PageRequest.of(Integer.parseInt(model.get("page")) - 1 , Integer.parseInt(model.get("maxPageItem")));
        List<BuildingDTO> results = buildingService.findAll(builder , pageable);
        return results;
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable("id") Long[] id) {
        buildingService.delete(id);
    }

    @GetMapping(value = "/building")
    public BuildingGetOne getById(@RequestParam("id") Long id){
        BuildingGetOne response = new BuildingGetOne();
        response.setBuildingDTO(buildingService.finById(id));
        return response;
    }

    @GetMapping(value = "/total")
    public Long getTotalItems(@RequestParam Map<String , String> model,
                              @RequestParam String[] buildingTypes){
        BuildingSearchBuilder builder = initBuildingBuider(model , buildingTypes);
        Long total = buildingService.getTotalItems(builder);
        return total;
    }

    @GetMapping(value = "/districts")
    public Map<String , String> getDistricts(){
        Map<String , String> result = buildingService.getDistrict();
        return result;
    }

    @GetMapping(value = "/type")
    public Map<String , String> getBuildingTypes(){
        Map<String , String> result = buildingService.getBuildingType();
        return result;
    }

    private BuildingSearchBuilder initBuildingBuider(Map<String , String> model , String[] buildingTypes) {
        BuildingSearchBuilder builder = new BuildingSearchBuilder.builder()
                .setName(model.get("name"))
                .setNumberOfBasement(model.get("numberOfBasement"))
                .setBuildingArea(model.get("buildingArea"))
                .setDistrict(model.get("district"))
                .setStreet(model.get("street"))
                .setWard(model.get("ward"))
                .setManagerName(model.get("managerName"))
                .setManagerPhone(model.get("managerPhone"))
                .setAreaRentFrom(model.get("areaRentFrom"))
                .setAreaRentTo(model.get("areaRentTo"))
                .setCostRentFrom(model.get("costRentFrom"))
                .setCostRentTo(model.get("costRentTo"))
                .setBuildingTypes(buildingTypes)
                .builder();
        return builder;
    }

}
