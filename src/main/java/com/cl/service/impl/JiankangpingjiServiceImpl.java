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


import com.cl.dao.JiankangpingjiDao;
import com.cl.entity.JiankangpingjiEntity;
import com.cl.service.JiankangpingjiService;
import com.cl.entity.view.JiankangpingjiView;

@Service("jiankangpingjiService")
public class JiankangpingjiServiceImpl extends ServiceImpl<JiankangpingjiDao, JiankangpingjiEntity> implements JiankangpingjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangpingjiEntity> page = this.selectPage(
                new Query<JiankangpingjiEntity>(params).getPage(),
                new EntityWrapper<JiankangpingjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangpingjiEntity> wrapper) {
		  Page<JiankangpingjiView> page =new Query<JiankangpingjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangpingjiView> selectListView(Wrapper<JiankangpingjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangpingjiView selectView(Wrapper<JiankangpingjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
