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


import com.cl.dao.WenjuanhuidaDao;
import com.cl.entity.WenjuanhuidaEntity;
import com.cl.service.WenjuanhuidaService;
import com.cl.entity.view.WenjuanhuidaView;

@Service("wenjuanhuidaService")
public class WenjuanhuidaServiceImpl extends ServiceImpl<WenjuanhuidaDao, WenjuanhuidaEntity> implements WenjuanhuidaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenjuanhuidaEntity> page = this.selectPage(
                new Query<WenjuanhuidaEntity>(params).getPage(),
                new EntityWrapper<WenjuanhuidaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenjuanhuidaEntity> wrapper) {
		  Page<WenjuanhuidaView> page =new Query<WenjuanhuidaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WenjuanhuidaView> selectListView(Wrapper<WenjuanhuidaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenjuanhuidaView selectView(Wrapper<WenjuanhuidaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
