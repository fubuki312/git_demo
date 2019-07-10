package cn.no1.dao;

import org.apache.ibatis.annotations.Param;

import cn.no1.pojo.BackendUser;

public interface BackendUserMapper {
	/**
	 * 用户登录
	 * @param userCode 用户名
	 * @param userPassword 用户密码
	 * @return Integer
	 */
	BackendUser userLogin(@Param("userCode")String userCode,
												@Param("userPassword")String userPassword);
	/**
	 * 查询用户信息
	 * @param backendUser
	 * @return
	 */
	BackendUser queryUser(BackendUser backendUser);
}
