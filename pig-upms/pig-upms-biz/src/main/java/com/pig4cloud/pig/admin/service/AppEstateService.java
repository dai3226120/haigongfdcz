package com.pig4cloud.pig.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.dto.EstateInfo;
import com.pig4cloud.pig.admin.api.dto.UserInfo;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.api.entity.SysUser;

public interface AppEstateService extends IService<AppEstateEntity> {

	/**
	 * 查询建筑信息
	 * @param appEstate 建筑
	 * @return EstateInfo
	 */
	EstateInfo findEstateInfo(AppEstateEntity appEstate);

}