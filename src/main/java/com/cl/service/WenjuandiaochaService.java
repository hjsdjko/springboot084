package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenjuandiaochaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjuandiaochaView;


/**
 * 问卷调查
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
public interface WenjuandiaochaService extends IService<WenjuandiaochaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenjuandiaochaView> selectListView(Wrapper<WenjuandiaochaEntity> wrapper);
   	
   	WenjuandiaochaView selectView(@Param("ew") Wrapper<WenjuandiaochaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenjuandiaochaEntity> wrapper);
   	

}

