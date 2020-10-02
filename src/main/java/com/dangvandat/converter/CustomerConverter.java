package com.dangvandat.converter;

import com.dangvandat.dto.CustomerDTO;
import com.dangvandat.entity.CustomerEntity;
import org.modelmapper.ModelMapper;

public class CustomerConverter {
    public CustomerDTO convertToDTO(CustomerEntity customerEntity) {
        ModelMapper modelMapper = new ModelMapper();
        @SuppressWarnings("unused")
        CustomerDTO result = modelMapper.map(customerEntity, CustomerDTO.class);
        return result;
    }

    public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        @SuppressWarnings("unused")
        CustomerEntity result = modelMapper.map(customerDTO, CustomerEntity.class);
        return result;
    }
}
