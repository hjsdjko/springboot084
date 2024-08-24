package com.cl.dao;

import com.cl.entity.TijianyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianyuyueView;


/**
 * 体检预约
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface TijianyuyueDao extends BaseMapper<TijianyuyueEntity> {
	
	List<TijianyuyueView> selectListView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);

	List<TijianyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	
	TijianyuyueView selectView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	

}
