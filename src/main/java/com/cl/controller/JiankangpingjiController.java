package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiankangpingjiEntity;
import com.cl.entity.view.JiankangpingjiView;

import com.cl.service.JiankangpingjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康评级
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@RestController
@RequestMapping("/jiankangpingji")
public class JiankangpingjiController {
    @Autowired
    private JiankangpingjiService jiankangpingjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangpingjiEntity jiankangpingji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequjumin")) {
			jiankangpingji.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangpingjiEntity> ew = new EntityWrapper<JiankangpingjiEntity>();

		PageUtils page = jiankangpingjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangpingji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangpingjiEntity jiankangpingji, 
		HttpServletRequest request){
        EntityWrapper<JiankangpingjiEntity> ew = new EntityWrapper<JiankangpingjiEntity>();

		PageUtils page = jiankangpingjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangpingji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangpingjiEntity jiankangpingji){
       	EntityWrapper<JiankangpingjiEntity> ew = new EntityWrapper<JiankangpingjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangpingji, "jiankangpingji")); 
        return R.ok().put("data", jiankangpingjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangpingjiEntity jiankangpingji){
        EntityWrapper< JiankangpingjiEntity> ew = new EntityWrapper< JiankangpingjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangpingji, "jiankangpingji")); 
		JiankangpingjiView jiankangpingjiView =  jiankangpingjiService.selectView(ew);
		return R.ok("查询健康评级成功").put("data", jiankangpingjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangpingjiEntity jiankangpingji = jiankangpingjiService.selectById(id);
		jiankangpingji = jiankangpingjiService.selectView(new EntityWrapper<JiankangpingjiEntity>().eq("id", id));
        return R.ok().put("data", jiankangpingji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangpingjiEntity jiankangpingji = jiankangpingjiService.selectById(id);
		jiankangpingji = jiankangpingjiService.selectView(new EntityWrapper<JiankangpingjiEntity>().eq("id", id));
        return R.ok().put("data", jiankangpingji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangpingjiEntity jiankangpingji, HttpServletRequest request){
    	jiankangpingji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangpingji);
        jiankangpingjiService.insert(jiankangpingji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangpingjiEntity jiankangpingji, HttpServletRequest request){
    	jiankangpingji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangpingji);
        jiankangpingjiService.insert(jiankangpingji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangpingjiEntity jiankangpingji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangpingji);
        jiankangpingjiService.updateById(jiankangpingji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangpingjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
