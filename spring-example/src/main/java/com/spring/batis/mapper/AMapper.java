package com.spring.batis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-12
 */
@Mapper
public interface AMapper {

	@Select("select * from a where id = #{id}")
	Map<String, Object> findById(@Param("id") Integer id);

	@Select("select * from a")
	List<Map<String, Object>> findAll();
}
