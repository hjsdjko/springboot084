package com.cl.dao;

import com.cl.entity.WenjuanhuidaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjuanhuidaView;


/**
 * 问卷回答
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
public interface WenjuanhuidaDao extends BaseMapper<WenjuanhuidaEntity> {
	
	List<WenjuanhuidaView> selectListView(@Param("ew") Wrapper<WenjuanhuidaEntity> wrapper);

	List<WenjuanhuidaView> selectListView(Pagination page,@Param("ew") Wrapper<WenjuanhuidaEntity> wrapper);
	
	WenjuanhuidaView selectView(@Param("ew") Wrapper<WenjuanhuidaEntity> wrapper);
	

}
