package com.xfeng.caringheart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.xfeng.caringheart.web.dto.User;
import com.xfeng.caringheart.web.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({
        @Mapping(source = "id", target = "id")
    })
	UserEntity createEntityFromDto(User dto);
	
	@Mappings({
        @Mapping(target = "password", ignore = true)
    })
	User createDtoFromEntity(UserEntity entity);

}
