package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TijianyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianyuyueView;


/**
 * 体检预约
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface TijianyuyueService extends IService<TijianyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijianyuyueView> selectListView(Wrapper<TijianyuyueEntity> wrapper);
   	
   	TijianyuyueView selectView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijianyuyueEntity> wrapper);
   	

}

