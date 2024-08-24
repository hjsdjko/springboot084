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


import com.cl.dao.JiankangdanganDao;
import com.cl.entity.JiankangdanganEntity;
import com.cl.service.JiankangdanganService;
import com.cl.entity.view.JiankangdanganView;

@Service("jiankangdanganService")
public class JiankangdanganServiceImpl extends ServiceImpl<JiankangdanganDao, JiankangdanganEntity> implements JiankangdanganService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangdanganEntity> page = this.selectPage(
                new Query<JiankangdanganEntity>(params).getPage(),
                new EntityWrapper<JiankangdanganEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangdanganEntity> wrapper) {
		  Page<JiankangdanganView> page =new Query<JiankangdanganView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangdanganView> selectListView(Wrapper<JiankangdanganEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangdanganView selectView(Wrapper<JiankangdanganEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
