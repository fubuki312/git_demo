package cn.no1.dao;

import org.apache.ibatis.annotations.Param;

import cn.no1.pojo.DevUser;

public interface DevUserMapper {
	DevUser userLogin(@Param("userCode")String userCode,
			@Param("userPassword")String userPassword);
}
