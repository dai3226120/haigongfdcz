package com.pig4cloud.pig.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pig4cloud.pig.admin.api.entity.SysUser;
import com.pig4cloud.pig.admin.service.SysDeptService;
import com.pig4cloud.pig.admin.service.SysUserService;
import com.pig4cloud.pig.common.core.exception.ErrorCodes;
import com.pig4cloud.pig.common.core.util.MsgUtils;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.security.util.SecurityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*")
public class TestController {


//	private final SysDeptService sysDeptService;

//	/**
//	 * 返回树形菜单集合
//	 * @param deptName 部门名称
//	 * @return 树形菜单
//	 */
//	@GetMapping(value = "/tree")
//	public R getTree(String deptName) {
//		return R.ok(sysDeptService.selectTree(deptName));
//	}
}
