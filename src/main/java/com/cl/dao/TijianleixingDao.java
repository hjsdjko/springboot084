package com.cl.dao;

import com.cl.entity.TijianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianleixingView;


/**
 * 体检类型
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface TijianleixingDao extends BaseMapper<TijianleixingEntity> {
	
	List<TijianleixingView> selectListView(@Param("ew") Wrapper<TijianleixingEntity> wrapper);

	List<TijianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<TijianleixingEntity> wrapper);
	
	TijianleixingView selectView(@Param("ew") Wrapper<TijianleixingEntity> wrapper);
	

}
