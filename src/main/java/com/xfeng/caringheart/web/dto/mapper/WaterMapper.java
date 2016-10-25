package com.xfeng.caringheart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.xfeng.caringheart.web.dto.HeartListData;
import com.xfeng.caringheart.web.entity.HeartEntity;

@Mapper(componentModel = "spring")
public interface WaterMapper {

	@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "date", target = "date"),
        @Mapping(source = "low", target = "low"),
        @Mapping(source = "high", target = "high")
    })
	HeartEntity createEntityFromDto(HeartListData dto);

	@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "date", target = "date"),
        @Mapping(source = "low", target = "low"),
        @Mapping(source = "high", target = "high")
    })
	HeartListData createDtoFromEntity(HeartEntity entity);

}
