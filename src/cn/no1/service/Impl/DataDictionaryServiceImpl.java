package cn.no1.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.no1.dao.DataDictionaryMapper;
import cn.no1.service.DataDictionaryService;

@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService{
	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
}
