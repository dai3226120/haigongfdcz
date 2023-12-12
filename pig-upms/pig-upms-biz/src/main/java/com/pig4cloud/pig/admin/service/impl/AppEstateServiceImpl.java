package com.pig4cloud.pig.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.AppEstateEntity;
import com.pig4cloud.pig.admin.mapper.AppEstateMapper;
import com.pig4cloud.pig.admin.service.AppEstateService;
import org.springframework.stereotype.Service;
/**
 * 建筑管理
 *
 * @author dw
 * @date 2023-12-11 18:32:52
 */
@Service
public class AppEstateServiceImpl extends ServiceImpl<AppEstateMapper, AppEstateEntity> implements AppEstateService {
}