package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangdanganEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangdanganView;


/**
 * 健康档案
 *
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
public interface JiankangdanganService extends IService<JiankangdanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangdanganView> selectListView(Wrapper<JiankangdanganEntity> wrapper);
   	
   	JiankangdanganView selectView(@Param("ew") Wrapper<JiankangdanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangdanganEntity> wrapper);
   	

}

