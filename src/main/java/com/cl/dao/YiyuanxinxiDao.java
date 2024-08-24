package com.cl.dao;

import com.cl.entity.YiyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiyuanxinxiView;


/**
 * 医院信息
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface YiyuanxinxiDao extends BaseMapper<YiyuanxinxiEntity> {
	
	List<YiyuanxinxiView> selectListView(@Param("ew") Wrapper<YiyuanxinxiEntity> wrapper);

	List<YiyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YiyuanxinxiEntity> wrapper);
	
	YiyuanxinxiView selectView(@Param("ew") Wrapper<YiyuanxinxiEntity> wrapper);
	

}
