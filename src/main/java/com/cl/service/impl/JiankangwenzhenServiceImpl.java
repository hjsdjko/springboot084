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


import com.cl.dao.JiankangwenzhenDao;
import com.cl.entity.JiankangwenzhenEntity;
import com.cl.service.JiankangwenzhenService;
import com.cl.entity.view.JiankangwenzhenView;

@Service("jiankangwenzhenService")
public class JiankangwenzhenServiceImpl extends ServiceImpl<JiankangwenzhenDao, JiankangwenzhenEntity> implements JiankangwenzhenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangwenzhenEntity> page = this.selectPage(
                new Query<JiankangwenzhenEntity>(params).getPage(),
                new EntityWrapper<JiankangwenzhenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangwenzhenEntity> wrapper) {
		  Page<JiankangwenzhenView> page =new Query<JiankangwenzhenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangwenzhenView> selectListView(Wrapper<JiankangwenzhenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangwenzhenView selectView(Wrapper<JiankangwenzhenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
