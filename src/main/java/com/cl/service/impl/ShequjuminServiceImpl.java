package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShequjuminDao;
import com.cl.entity.ShequjuminEntity;
import com.cl.service.ShequjuminService;
import com.cl.entity.view.ShequjuminView;

@Service("shequjuminService")
public class ShequjuminServiceImpl extends ServiceImpl<ShequjuminDao, ShequjuminEntity> implements ShequjuminService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequjuminEntity> page = this.selectPage(
                new Query<ShequjuminEntity>(params).getPage(),
                new EntityWrapper<ShequjuminEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequjuminEntity> wrapper) {
		  Page<ShequjuminView> page =new Query<ShequjuminView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShequjuminView> selectListView(Wrapper<ShequjuminEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequjuminView selectView(Wrapper<ShequjuminEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
