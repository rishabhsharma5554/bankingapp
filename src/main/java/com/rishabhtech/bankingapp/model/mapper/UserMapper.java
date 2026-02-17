package com.rishabhtech.bankingapp.model.mapper;

import com.rishabhtech.bankingapp.model.dto.UserDto;
import com.rishabhtech.bankingapp.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //mapping entity to dto
    @Mapping(target = "password", ignore = true)
    UserDto toDTO(User user);

    //mapping dto to entity, if email is null, then set it to default email
    @Mapping(target = "emailId", expression = "java(userDto.getEmailId() == null || userDto.getEmailId().isEmpty() ? \"no-email@rishabhtech.com\" : userDto.getEmailId())")
    User toEntity(UserDto userDto);
}