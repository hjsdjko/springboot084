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


import com.cl.dao.YiyuanxinxiDao;
import com.cl.entity.YiyuanxinxiEntity;
import com.cl.service.YiyuanxinxiService;
import com.cl.entity.view.YiyuanxinxiView;

@Service("yiyuanxinxiService")
public class YiyuanxinxiServiceImpl extends ServiceImpl<YiyuanxinxiDao, YiyuanxinxiEntity> implements YiyuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiyuanxinxiEntity> page = this.selectPage(
                new Query<YiyuanxinxiEntity>(params).getPage(),
                new EntityWrapper<YiyuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiyuanxinxiEntity> wrapper) {
		  Page<YiyuanxinxiView> page =new Query<YiyuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiyuanxinxiView> selectListView(Wrapper<YiyuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiyuanxinxiView selectView(Wrapper<YiyuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
