package com.dangvandat.converter;

import org.modelmapper.ModelMapper;

import com.dangvandat.entity.UserEntity;
import com.dangvandat.dto.UserDTO;

public class UserConverter {
	
	public UserDTO convertToDTO(UserEntity userEntity) {
		ModelMapper modelMapper = new ModelMapper();
		@SuppressWarnings("unused")
		UserDTO result = modelMapper.map(userEntity, UserDTO.class);
		return result;
	}
	
	public UserEntity convertToEntity(UserDTO userDTO) {
		ModelMapper modelMapper = new ModelMapper();
		@SuppressWarnings("unused")
		UserEntity result = modelMapper.map(userDTO, UserEntity.class);
		return result;
	}
	
}
