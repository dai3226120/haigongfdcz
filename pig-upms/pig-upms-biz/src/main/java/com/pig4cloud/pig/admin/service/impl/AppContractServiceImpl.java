package com.pig4cloud.pig.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.entity.AppContractEntity;
import com.pig4cloud.pig.admin.mapper.AppContractMapper;
import com.pig4cloud.pig.admin.service.AppContractService;
import org.springframework.stereotype.Service;
/**
 * 合同管理
 *
 * @author dw
 * @date 2023-12-13 10:22:43
 */
@Service
public class AppContractServiceImpl extends ServiceImpl<AppContractMapper, AppContractEntity> implements AppContractService {
}