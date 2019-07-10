package cn.no1.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.no1.pojo.AppInfo;
import cn.no1.pojo.DevUser;
import cn.no1.pojo.Page;
import cn.no1.service.AppInfoService;
import cn.no1.service.DevUserService;

@Controller
@RequestMapping("/dev")
public class DevController {
	@Resource
	private DevUserService devUserService;
	@Resource
	private AppInfoService appInfoService;
	/**
	 * 跳转开发者登录页面
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String toLogin() {
		return "devlogin";
	}
	@RequestMapping("logout")
	public String loginOut(HttpServletRequest request) {
		request.getSession().invalidate();//清除
		return "redirect:/dev/login";
	}
	
	/**
	 * 开发者登录判断跳转
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	@RequestMapping(value = "/userLogin",method  = RequestMethod.POST)
	public String userLogin(@RequestParam(value = "devCode")String devCode,@RequestParam(value = "devPassword")String devPassword,HttpServletRequest request) {
			System.out.println("用户名："+devCode+" 密码："+devPassword);
			DevUser user = devUserService.userLogin(devCode, devPassword);
			if(user != null) {
				request.getSession().setAttribute("devUserSession", user);
				return "developer/main";
			}else {
				System.out.println("不正确");
				request.getSession().setAttribute("error", "账号或密码输入不正确");
				return "redirect:/dev/login";
			}	
	}
	@RequestMapping("/flatform/app/list")
	public String toAppInfoList(@RequestParam(value = "querySoftwareName",required = false)String softwareName,
													@RequestParam(value = "queryStatus",required = false)Integer status,
													@RequestParam(value = "queryFlatformId",required = false)Integer flatformId,
													@RequestParam(value = "queryCategoryLevel1",required = false)Integer categoryLevel1,
													@RequestParam(value = "queryCategoryLevel2",required = false)Integer categoryLevel2,
													@RequestParam(value = "queryCategoryLevel3",required = false)Integer categoryLevel3,
													@RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
													Model model) {
		System.out.println("softwareName："+softwareName);
		System.out.println("status："+status);
		System.out.println("flatformId："+flatformId);
		System.out.println("categoryLevel1："+categoryLevel1);
		System.out.println("categoryLevel2："+categoryLevel2);
		System.out.println("categoryLevel3："+categoryLevel3);
		AppInfo appInfo = new AppInfo(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		Integer count = appInfoService.queryAppInfoCount(appInfo);
		System.out.println("这是总记录数："+count);
		Page page = new Page();
		page.setPageSize(5);
		page.setCurrPageNo(pageIndex);
		page.setTotalCount(count);
		Integer from = (page.getCurrPageNo() -1 ) * page.getPageSize();
		List<AppInfo> appInfos = appInfoService.queryAppInfoList(appInfo, from, page.getPageSize());
		List<AppInfo> status2 = appInfoService.queryAppStatus();
		List<AppInfo > flatFormList = appInfoService.queryAppFlatForm();
		List<AppInfo> categoryLevel12 = appInfoService.queryAppcCategoryLevel1();
		model.addAttribute("statusList",status2);
		model.addAttribute("flatFormList",flatFormList);
		model.addAttribute("categoryLevel1List",categoryLevel12);
		model.addAttribute("appInfoList",appInfos);
		model.addAttribute("pages",page);
		model.addAttribute("querySoftwareName",softwareName);
		model.addAttribute("queryStatus",status);
		model.addAttribute("queryFlatformId",flatformId);
		model.addAttribute("queryCategoryLevel1",categoryLevel1);
		model.addAttribute("queryCategoryLevel2",categoryLevel2);
		model.addAttribute("queryCategoryLevel3",categoryLevel3);
		return "developer/appinfolist";
	}
	@RequestMapping(value = "categorylevellist.json",method = RequestMethod.GET)
	@ResponseBody
	public Object returnCategoryleveJSON(@RequestParam(value = "pid",required = false)Integer pid) {
		List<AppInfo> appInfos = appInfoService.queryAppcCategoryLevel2(pid);
		return JSONArray.toJSONString(appInfos);
	}
}
