package com.cl.dao;

import com.cl.entity.BingqingyuceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BingqingyuceView;


/**
 * 病情预测
 * 
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface BingqingyuceDao extends BaseMapper<BingqingyuceEntity> {
	
	List<BingqingyuceView> selectListView(@Param("ew") Wrapper<BingqingyuceEntity> wrapper);

	List<BingqingyuceView> selectListView(Pagination page,@Param("ew") Wrapper<BingqingyuceEntity> wrapper);
	
	BingqingyuceView selectView(@Param("ew") Wrapper<BingqingyuceEntity> wrapper);
	

}
