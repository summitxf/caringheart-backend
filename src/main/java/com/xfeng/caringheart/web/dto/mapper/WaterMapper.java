package com.xfeng.caringheart.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.xfeng.caringheart.web.dto.WaterListData;
import com.xfeng.caringheart.web.entity.WaterEntity;

@Mapper(componentModel = "spring")
public interface WaterMapper {

	@Mappings({
		@Mapping(source = "userid", target = "userid")
    })
	WaterEntity createEntityFromDto(WaterListData dto, String userid);

	WaterListData createDtoFromEntity(WaterEntity entity);


}
