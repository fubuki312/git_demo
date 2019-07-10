package cn.no1.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.no1.pojo.BackendUser;
import cn.no1.service.BackendUserService;

@Controller
@RequestMapping("/manager")
public class BackController {
	
	@Resource
	private BackendUserService backendUserService;
	
	/**
	 * 跳转管理登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String toLogin() {
		return "backendlogin";
	}
	@RequestMapping("/logout")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();//清除
		return "redirect:/manager/login";
	}
	
	/**
	 * 管理用户登录判断
	 * @param devCode 用户名
	 * @param devPassword 用户密码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST)
	public String userLogin(@RequestParam(value = "userCode")String userCode,@RequestParam(value = "userPassword")String userPassword,HttpServletRequest request) {
		System.out.println("用户名："+userCode+" 密码："+userPassword);
		BackendUser user = backendUserService.userLogin(userCode, userPassword);
		if(user != null) {
			user = backendUserService.queryUser(user);
			request.getSession().setAttribute("userSession", user);
			return "backend/main";
		}else {
			System.out.println("不正确");
			request.getSession().setAttribute("error", "账号或密码输入不正确");
			return "redirect:/manager/login";
		}	
	}
	
}
