package cn.no1.service;

import cn.no1.pojo.DevUser;

public interface DevUserService {
	DevUser userLogin(String userCode,String userPassword);
}
