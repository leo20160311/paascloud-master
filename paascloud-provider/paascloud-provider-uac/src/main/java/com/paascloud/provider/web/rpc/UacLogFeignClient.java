/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacLogMainController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.provider.web.rpc;

import com.paascloud.provider.model.dto.log.UacLogMainDto;
import com.paascloud.provider.model.service.UacLogFeignApi;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理.
 *
 * @author paascloud.net@gmail.com
 */
@RefreshScope
@RestController
@Api(value = "API - UacLogFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacLogFeignClient implements UacLogFeignApi {

	@Override
	public Wrapper queryLogListWithPage(UacLogMainDto uacLogQueryDtoPage) {
		return null;
	}
}
