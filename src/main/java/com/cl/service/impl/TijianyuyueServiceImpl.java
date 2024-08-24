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


import com.cl.dao.TijianyuyueDao;
import com.cl.entity.TijianyuyueEntity;
import com.cl.service.TijianyuyueService;
import com.cl.entity.view.TijianyuyueView;

@Service("tijianyuyueService")
public class TijianyuyueServiceImpl extends ServiceImpl<TijianyuyueDao, TijianyuyueEntity> implements TijianyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijianyuyueEntity> page = this.selectPage(
                new Query<TijianyuyueEntity>(params).getPage(),
                new EntityWrapper<TijianyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijianyuyueEntity> wrapper) {
		  Page<TijianyuyueView> page =new Query<TijianyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TijianyuyueView> selectListView(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijianyuyueView selectView(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
