package com.xfeng.caringheart.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xfeng.caringheart.web.dao.WeixinMessageMapper;
import com.xfeng.caringheart.web.model.Message;

@Component
public class WeixinMessageService {

	@Autowired
	private WeixinMessageMapper weixinMessageMapper;

	public Message getMessageById(String string) {
		return weixinMessageMapper.getMessageById(string);
	}

}
