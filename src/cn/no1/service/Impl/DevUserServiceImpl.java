package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.DevUserMapper;
import cn.no1.pojo.DevUser;
import cn.no1.service.DevUserService;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService{
	@Resource
	private DevUserMapper devUserMapper;

	@Override
	public DevUser userLogin(String userCode, String userPassword) {
		return devUserMapper.userLogin(userCode, userPassword);
	}
}
