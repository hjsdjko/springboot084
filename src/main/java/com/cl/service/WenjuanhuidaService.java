package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenjuanhuidaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjuanhuidaView;


/**
 * 问卷回答
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
public interface WenjuanhuidaService extends IService<WenjuanhuidaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenjuanhuidaView> selectListView(Wrapper<WenjuanhuidaEntity> wrapper);
   	
   	WenjuanhuidaView selectView(@Param("ew") Wrapper<WenjuanhuidaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenjuanhuidaEntity> wrapper);
   	

}

