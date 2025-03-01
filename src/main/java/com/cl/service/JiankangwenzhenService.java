package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangwenzhenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangwenzhenView;


/**
 * 健康问诊
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangwenzhenService extends IService<JiankangwenzhenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangwenzhenView> selectListView(Wrapper<JiankangwenzhenEntity> wrapper);
   	
   	JiankangwenzhenView selectView(@Param("ew") Wrapper<JiankangwenzhenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangwenzhenEntity> wrapper);
   	

}

