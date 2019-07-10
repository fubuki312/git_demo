package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.AdPromotionMapper;
import cn.no1.service.AdPromotionService;
@Service("adPromotionService")
public class AdPromotionServiceImpl implements AdPromotionService{
	@Resource
	private AdPromotionMapper adPromotionMapper;
}
