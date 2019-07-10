package cn.no1.service;

import cn.no1.pojo.BackendUser;

public interface BackendUserService {
	BackendUser userLogin(String userCode,String userPassword);
	BackendUser queryUser(BackendUser backendUser);
}
