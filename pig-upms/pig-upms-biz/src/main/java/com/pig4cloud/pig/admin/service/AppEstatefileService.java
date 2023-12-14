package com.pig4cloud.pig.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.admin.api.dto.EstateFileDTO;
import com.pig4cloud.pig.admin.api.entity.AppEstatefileEntity;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.web.multipart.MultipartFile;

public interface AppEstatefileService extends IService<AppEstatefileEntity> {

	/**
	 * 上传文件
	 * @param file
	 * @param estateFileDTO
	 * @return
	 */
	R uploadFile(MultipartFile file, EstateFileDTO estateFileDTO);

}