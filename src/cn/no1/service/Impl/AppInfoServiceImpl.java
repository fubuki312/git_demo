package cn.no1.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.AppInfoMapper;
import cn.no1.pojo.AppInfo;
import cn.no1.service.AppInfoService;
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService{
	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> queryAppInfoList(AppInfo appInfo, Integer from, Integer size) {
		return appInfoMapper.queryAppInfoList(appInfo, from, size);
	}

	@Override
	public Integer queryAppInfoCount(AppInfo appInfo) {
		return appInfoMapper.queryAppInfoCount(appInfo);
	}

	@Override
	public List<AppInfo> queryAppStatus() {
		return appInfoMapper.queryAppStatus();
	}

	@Override
	public List<AppInfo> queryAppFlatForm() {
		return appInfoMapper.queryAppFlatForm();
	}

	@Override
	public List<AppInfo> queryAppcCategoryLevel1() {
		return appInfoMapper.queryAppcCategoryLevel1();
	}

	@Override
	public List<AppInfo> queryAppcCategoryLevel2(Integer id) {
		return appInfoMapper.queryAppcCategoryLevel2(id);
	}

	@Override
	public List<AppInfo> queryAppcCategoryLevel3(Integer id) {
		return appInfoMapper.queryAppcCategoryLevel3(id);
	}

}
