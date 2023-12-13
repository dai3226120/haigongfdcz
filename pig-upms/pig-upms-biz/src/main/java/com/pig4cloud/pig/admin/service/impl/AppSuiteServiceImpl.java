package com.pig4cloud.pig.admin.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.dto.SuiteDTO;
import com.pig4cloud.pig.admin.api.entity.AppDistrict;
import com.pig4cloud.pig.admin.api.entity.AppSuiteEntity;
import com.pig4cloud.pig.admin.api.vo.EstateSuiteVO;
import com.pig4cloud.pig.admin.api.vo.SuiteVO;
import com.pig4cloud.pig.admin.api.vo.UserVO;
import com.pig4cloud.pig.admin.mapper.AppSuiteMapper;
import com.pig4cloud.pig.admin.service.AppSuiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 房屋管理
 *
 * @author dw
 * @date 2023-12-13 10:13:09
 */
@Service
@AllArgsConstructor
public class AppSuiteServiceImpl extends ServiceImpl<AppSuiteMapper, AppSuiteEntity> implements AppSuiteService {

	private final AppSuiteMapper suiteMapper;


	@Override
	public IPage getSuitesAllPage(Page page, SuiteVO suiteVO) {
		return baseMapper.getSuiteVosPage(page, suiteVO);
	}



}