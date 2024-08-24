package com.cl.dao;

import com.cl.entity.ShequjuminEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequjuminView;


/**
 * 社区居民
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:26
 */
public interface ShequjuminDao extends BaseMapper<ShequjuminEntity> {
	
	List<ShequjuminView> selectListView(@Param("ew") Wrapper<ShequjuminEntity> wrapper);

	List<ShequjuminView> selectListView(Pagination page,@Param("ew") Wrapper<ShequjuminEntity> wrapper);
	
	ShequjuminView selectView(@Param("ew") Wrapper<ShequjuminEntity> wrapper);
	

}
