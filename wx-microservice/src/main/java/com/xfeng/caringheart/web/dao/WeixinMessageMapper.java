package com.xfeng.caringheart.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.xfeng.caringheart.web.model.Message;

@Mapper
public interface WeixinMessageMapper {

	Message getMessageById(String string);

}
