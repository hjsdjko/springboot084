package com.cl.dao;

import com.cl.entity.WenjuandiaochaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjuandiaochaView;


/**
 * 问卷调查
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
public interface WenjuandiaochaDao extends BaseMapper<WenjuandiaochaEntity> {
	
	List<WenjuandiaochaView> selectListView(@Param("ew") Wrapper<WenjuandiaochaEntity> wrapper);

	List<WenjuandiaochaView> selectListView(Pagination page,@Param("ew") Wrapper<WenjuandiaochaEntity> wrapper);
	
	WenjuandiaochaView selectView(@Param("ew") Wrapper<WenjuandiaochaEntity> wrapper);
	

}
