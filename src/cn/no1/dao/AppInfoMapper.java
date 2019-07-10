package cn.no1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.no1.pojo.AppInfo;

public interface AppInfoMapper {
	/**
	 * 根据条件查询APP信息进行分页
	 * @param appInfo
	 * @param from
	 * @param size
	 * @return
	 */
	List<AppInfo> queryAppInfoList(@Param("appInfo")AppInfo appInfo,@Param("from")Integer from,@Param("size")Integer size);
	/**
	 * 根据条件查询APP信息记录数
	 * @param appInfo
	 * @return
	 */
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
	List<AppInfo> queryAppcCategoryLevel2(@Param("id")Integer id);
	/**
	 * 查找所有APP三级分类
	 * @param id
	 * @return
	 */
	List<AppInfo> queryAppcCategoryLevel3(@Param("id")Integer id);
}
