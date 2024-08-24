package com.cl.dao;

import com.cl.entity.JiankangdanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangdanganView;


/**
 * 健康档案
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangdanganDao extends BaseMapper<JiankangdanganEntity> {
	
	List<JiankangdanganView> selectListView(@Param("ew") Wrapper<JiankangdanganEntity> wrapper);

	List<JiankangdanganView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangdanganEntity> wrapper);
	
	JiankangdanganView selectView(@Param("ew") Wrapper<JiankangdanganEntity> wrapper);
	

}
