package com.cl.dao;

import com.cl.entity.JiankangpingjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangpingjiView;


/**
 * 健康评级
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangpingjiDao extends BaseMapper<JiankangpingjiEntity> {
	
	List<JiankangpingjiView> selectListView(@Param("ew") Wrapper<JiankangpingjiEntity> wrapper);

	List<JiankangpingjiView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangpingjiEntity> wrapper);
	
	JiankangpingjiView selectView(@Param("ew") Wrapper<JiankangpingjiEntity> wrapper);
	

}
