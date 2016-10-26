package com.xfeng.caringheart.web.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.xfeng.caringheart.web.dto.HeartListData;
import com.xfeng.caringheart.web.entity.HeartEntity;

@Mapper(componentModel = "spring")
public interface HeartMapper {

	HeartEntity createEntityFromDto(HeartListData heart);
	
	@Mappings({
        @Mapping(source = "userid", target = "userid")
    })
	HeartEntity createEntityFromDto(HeartListData heart, String userid);
	
	@Mappings({
		@Mapping(target = "date", dateFormat = "HH:mm:ss")
	})
	HeartListData createDtoFromEntity(HeartEntity entity);
	
	List<HeartListData> createDtosFromEntities(List<HeartEntity> entities);

}
