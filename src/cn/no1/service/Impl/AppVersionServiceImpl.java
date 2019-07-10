package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.AppVersionMapper;
import cn.no1.service.AppVersionService;
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService{
	@Resource
	private AppVersionMapper appVersionMapper;

}
