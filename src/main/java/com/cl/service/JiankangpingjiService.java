package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangpingjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangpingjiView;


/**
 * 健康评级
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangpingjiService extends IService<JiankangpingjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangpingjiView> selectListView(Wrapper<JiankangpingjiEntity> wrapper);
   	
   	JiankangpingjiView selectView(@Param("ew") Wrapper<JiankangpingjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangpingjiEntity> wrapper);
   	

}

