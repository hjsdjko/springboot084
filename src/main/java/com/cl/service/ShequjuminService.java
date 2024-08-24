package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShequjuminEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequjuminView;


/**
 * 社区居民
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:26
 */
public interface ShequjuminService extends IService<ShequjuminEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequjuminView> selectListView(Wrapper<ShequjuminEntity> wrapper);
   	
   	ShequjuminView selectView(@Param("ew") Wrapper<ShequjuminEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequjuminEntity> wrapper);
   	

}

