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


import com.cl.dao.BingqingyuceDao;
import com.cl.entity.BingqingyuceEntity;
import com.cl.service.BingqingyuceService;
import com.cl.entity.view.BingqingyuceView;

@Service("bingqingyuceService")
public class BingqingyuceServiceImpl extends ServiceImpl<BingqingyuceDao, BingqingyuceEntity> implements BingqingyuceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BingqingyuceEntity> page = this.selectPage(
                new Query<BingqingyuceEntity>(params).getPage(),
                new EntityWrapper<BingqingyuceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BingqingyuceEntity> wrapper) {
		  Page<BingqingyuceView> page =new Query<BingqingyuceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BingqingyuceView> selectListView(Wrapper<BingqingyuceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BingqingyuceView selectView(Wrapper<BingqingyuceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
