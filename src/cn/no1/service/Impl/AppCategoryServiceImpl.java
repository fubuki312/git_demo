package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.AppCategoryMapper;
import cn.no1.service.AppCategoryService;

@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService{
	@Resource
	private AppCategoryMapper appCategoryMapper;

}
