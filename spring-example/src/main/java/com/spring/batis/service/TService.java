package com.spring.batis.service;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-12
 */
public interface TService {

	Map<String, Object> findById(Integer id);

	List<Map<String, Object>> findAll();
}
