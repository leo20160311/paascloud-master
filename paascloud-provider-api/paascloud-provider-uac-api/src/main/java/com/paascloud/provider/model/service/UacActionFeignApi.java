/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacActionMainController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.provider.model.service;

import com.paascloud.provider.model.dto.action.ActionMainQueryDto;
import com.paascloud.provider.model.dto.action.UacActionCheckCodeDto;
import com.paascloud.provider.model.dto.action.UacActionCheckUrlDto;
import com.paascloud.provider.model.dto.base.ModifyStatusDto;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * The class Uac action main controller.
 *
 * @author paascloud.net @gmail.com
 */
@FeignClient(value = "paascloud-provider-uac")
public interface UacActionFeignApi{

	/**
	 * 分页查询角色信息.
	 *
	 * @param action the action
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/queryListWithPage")
	Wrapper queryUacActionListWithPage(@ApiParam(name = "action", value = "角色信息") @RequestBody ActionMainQueryDto action);

	/**
	 * 删除角色信息.
	 *
	 * @param id the id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/deleteActionById/{id}")
	Wrapper deleteUacActionById(@ApiParam(name = "id", value = "角色id") @PathVariable Long id);

	/**
	 * 批量删除角色.
	 *
	 * @param deleteIdList the delete id list
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/batchDeleteByIdList")
	Wrapper batchDeleteByIdList(@ApiParam(name = "deleteIdList", value = "角色Id") @RequestBody List<Long> deleteIdList);


	/**
	 * 保存权限信息.
	 *
	 * @param action the action
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/save")
	Wrapper save(@ApiParam(name = "action", value = "角色信息") @RequestBody ActionMainQueryDto action);

	/**
	 * 根据权限Id修改角色状态.
	 *
	 * @param modifyStatusDto the modify status dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/modifyStatus")
	Wrapper modifyActionStatus(@ApiParam(name = "modifyActionStatus", value = "修改权限状态") @RequestBody ModifyStatusDto modifyStatusDto);

	/**
	 * 检测权限编码是否已存在
	 *
	 * @param uacActionCheckCodeDto the uac action check code dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkActionCode")
	Wrapper<Boolean> checkActionCode(@ApiParam(name = "uacActionCheckCodeDto", value = "id与url") @RequestBody UacActionCheckCodeDto uacActionCheckCodeDto);

	/**
	 * 检测权限URL唯一性
	 *
	 * @param uacActionCheckUrlDto the uac action check url dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkUrl")
	Wrapper<Boolean> checkActionUrl(@ApiParam(name = "uacActionCheckUrlDto", value = "id与url") @RequestBody UacActionCheckUrlDto uacActionCheckUrlDto);
}
