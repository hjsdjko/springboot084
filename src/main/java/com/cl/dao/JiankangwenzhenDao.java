package com.cl.dao;

import com.cl.entity.JiankangwenzhenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangwenzhenView;


/**
 * 健康问诊
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangwenzhenDao extends BaseMapper<JiankangwenzhenEntity> {
	
	List<JiankangwenzhenView> selectListView(@Param("ew") Wrapper<JiankangwenzhenEntity> wrapper);

	List<JiankangwenzhenView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangwenzhenEntity> wrapper);
	
	JiankangwenzhenView selectView(@Param("ew") Wrapper<JiankangwenzhenEntity> wrapper);
	

}
