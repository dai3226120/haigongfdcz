package com.pig4cloud.pig.admin.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.dto.EstateInfo;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.api.entity.AppQsdwEntity;
import com.pig4cloud.pig.admin.api.entity.SysMenu;
import com.pig4cloud.pig.admin.api.entity.SysRole;
import com.pig4cloud.pig.admin.mapper.AppEstateMapper;
import com.pig4cloud.pig.admin.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 建筑管理
 *
 * @author dw
 * @date 2023-12-11 18:32:52
 */
@Slf4j
@Service
@AllArgsConstructor
public class AppEstateServiceImpl extends ServiceImpl<AppEstateMapper, AppEstateEntity> implements AppEstateService {

	private final AppYjqyService appYjqyService;

	private final AppDistrictService appDistrictService;

	private final AppQsdwService appQsdwService;

	private final AppEstatefunctionService appEstatefunctionService;

	private final AppEstatetypeService appEstatetypeService;

	private final AppLandstatusService appLandstatusService;

	@Override
	public EstateInfo findEstateInfo(AppEstateEntity appEstate) {
		EstateInfo estateInfo = new EstateInfo();
		estateInfo.setAppEstate(appEstate);
		estateInfo.setAppDistrict(appDistrictService.listDescendant(appEstate.getEstateDistrictCode()));
		estateInfo.setAppYjqy(appYjqyService.getById(appEstate.getYjqyId()));
		estateInfo.setAppQsdw(appQsdwService.getById(estateInfo.getAppQsdw()));
		estateInfo.setAppEstatefunction(appEstatefunctionService.getById(estateInfo.getAppEstatefunction()));
		estateInfo.setAppEstatetype(appEstatetypeService.getById(estateInfo.getAppEstatetype()));
		estateInfo.setAppLandstatus(appLandstatusService.getById(estateInfo.getAppLandstatus()));

		return estateInfo;
	}
}