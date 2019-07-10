package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.BackendUserMapper;
import cn.no1.pojo.BackendUser;
import cn.no1.service.BackendUserService;

@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService{
	@Resource
	private BackendUserMapper backendUserMapper;

	@Override
	public BackendUser userLogin(String userCode, String userPassword) {
		return backendUserMapper.userLogin(userCode, userPassword);
	}

	@Override
	public BackendUser queryUser(BackendUser backendUser) {
		return backendUserMapper.queryUser(backendUser);
	}
}
