package com.pig4cloud.pig.admin.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.admin.api.dto.EstateFileDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.admin.api.entity.SysFile;
import com.pig4cloud.pig.admin.mapper.AppEstatefileMapper;
import com.pig4cloud.pig.admin.mapper.SysFileMapper;
import com.pig4cloud.pig.admin.service.AppEstatefileService;
import com.pig4cloud.pig.admin.service.SysFileService;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.file.core.FileProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 资产文件
 *
 * @author dw
 * @date 2023-12-14 16:33:03
 */
@Service
@AllArgsConstructor
public class AppEstatefileServiceImpl extends ServiceImpl<AppEstatefileMapper, AppEstatefileEntity> implements AppEstatefileService {

	private final SysFileService sysFileService;
	private final FileProperties properties;
	private final SysFileMapper sysFileMapper;

	/**
	 * 上传文件
	 * @param file
	 * @param estateFileDTO
	 * @return
	 */

	@Override
	public R uploadFile(MultipartFile file, EstateFileDTO estateFileDTO) {
		SysFile sysFile;
		String fileName;

//		String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());
		Map<String, String> resultMap = new HashMap<>(4);
		resultMap.put("bucketName", properties.getBucketName());
		resultMap.put("estateId", estateFileDTO.getEstateId() == null ? null : estateFileDTO.getEstateId().toString());
		resultMap.put("suiteId", estateFileDTO.getSuiteId() == null ? null : estateFileDTO.getSuiteId().toString());

		try {
			String jsonString  = sysFileService.uploadFile(file).getData().toString();
			jsonString = jsonString.substring(1, jsonString.length() - 1).replaceAll("([^,=\\s]+)=([^,}]+)", "\"$1\":\"$2\"");
			JSONObject jsonObject = JSONObject.parseObject("{" + jsonString + "}");
			fileName = jsonObject.getString("fileName");
			resultMap.put("fileName", fileName);
			resultMap.put("url", String.format("/admin/sys-file/%s/%s", properties.getBucketName(), fileName));



			// 文件管理数据记录,收集管理追踪文件
			estateFileLog(file, fileName, estateFileDTO);
		}
		catch (Exception e) {
			log.error("上传失败", e);
			return R.failed(e.getLocalizedMessage());
		}
		LambdaQueryWrapper<SysFile> wrapper = Wrappers.<SysFile>lambdaQuery();
		wrapper.eq(SysFile::getFileName, fileName)
				.select(SysFile::getId)
				.last("LIMIT 1");

		sysFile = sysFileMapper.selectOne(wrapper);

		resultMap.put("fileId", sysFile != null ? sysFile.getId().toString() : null);

		return R.ok(resultMap);
	}

	/**
	 * 文件管理数据记录,收集管理追踪文件
	 * @param file 上传文件格式
	 * @param fileName 文件名
	 */
	private void estateFileLog(MultipartFile file, String fileName, EstateFileDTO estateFileDTO) {
		AppEstatefileEntity estatefile = new AppEstatefileEntity();
		estatefile.setEstatefileName(fileName);
		estatefile.setOriginal(file.getOriginalFilename());
		estatefile.setFileSize(file.getSize());
		estatefile.setType(FileUtil.extName(file.getOriginalFilename()));
		estatefile.setBucketName(properties.getBucketName());
		estatefile.setEstateId(estateFileDTO.getEstateId());
		estatefile.setSuiteId(estatefile.getSuiteId());
		this.save(estatefile);
	}

}
