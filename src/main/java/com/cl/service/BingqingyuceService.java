package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BingqingyuceEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BingqingyuceView;


/**
 * 病情预测
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface BingqingyuceService extends IService<BingqingyuceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BingqingyuceView> selectListView(Wrapper<BingqingyuceEntity> wrapper);
   	
   	BingqingyuceView selectView(@Param("ew") Wrapper<BingqingyuceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BingqingyuceEntity> wrapper);
   	

}

