package com.dangvandat.api;

import com.dangvandat.builder.CustomerSearchBuilder;
import com.dangvandat.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerAPI {

    @GetMapping
    public List<CustomerDTO> showCustomer(@RequestParam Map<String , String> model){
        CustomerSearchBuilder customerSearchBuilder =initCustomer(model);
        return null;
    }

    private CustomerSearchBuilder initCustomer(Map<String , String> model){
        CustomerSearchBuilder builder = new CustomerSearchBuilder.builder()
                .setCompanyName(model.get("companyName"))
                .builder();
        return builder;
    }
}
