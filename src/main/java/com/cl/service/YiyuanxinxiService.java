package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiyuanxinxiView;


/**
 * 医院信息
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface YiyuanxinxiService extends IService<YiyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiyuanxinxiView> selectListView(Wrapper<YiyuanxinxiEntity> wrapper);
   	
   	YiyuanxinxiView selectView(@Param("ew") Wrapper<YiyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiyuanxinxiEntity> wrapper);
   	

}

