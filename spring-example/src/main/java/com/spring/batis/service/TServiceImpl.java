package com.spring.batis.service;

import com.spring.batis.mapper.AMapper;
import com.spring.batis.mapper.TMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-12
 */
@Service
public class TServiceImpl implements TService {

	// 对象
	// mapper 如何产生
	@Autowired
	private TMapper tMapper;

	@Autowired
	private AMapper aMapper;

	@Override
	public Map<String, Object> findById(Integer id) {
		aMapper.findById(id);
		return tMapper.findById(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		aMapper.findAll();
		return tMapper.findAll();
	}
}
