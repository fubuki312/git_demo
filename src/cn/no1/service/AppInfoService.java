package cn.no1.service;

import java.util.List;

import cn.no1.pojo.AppInfo;

public interface AppInfoService {
	List<AppInfo> queryAppInfoList(AppInfo appInfo,Integer from,Integer size);
	Integer queryAppInfoCount(AppInfo appInfo);
	/**
	 * 查找所有APP状态
	 * @return
	 */
	List<AppInfo> queryAppStatus();
	/**
	 * 查找所有APP平台
	 * @return
	 */
	List<AppInfo> queryAppFlatForm();
	/**
	 * 查找所有APP一级分类
	 * @return
	 */
	List<AppInfo> queryAppcCategoryLevel1();
	/**
	 * 查找所有APP二级分类
	 * @param id
	 * @return
	 */
	List<AppInfo> queryAppcCategoryLevel2(Integer id);
	/**
	 * 查找所有APP三级分类
	 * @param id
	 * @return
	 */
	List<AppInfo> queryAppcCategoryLevel3(Integer id);

}
