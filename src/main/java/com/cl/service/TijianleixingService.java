package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TijianleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianleixingView;


/**
 * 体检类型
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface TijianleixingService extends IService<TijianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijianleixingView> selectListView(Wrapper<TijianleixingEntity> wrapper);
   	
   	TijianleixingView selectView(@Param("ew") Wrapper<TijianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijianleixingEntity> wrapper);
   	

}

