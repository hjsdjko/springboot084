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

import com.cl.entity.WenjuandiaochaEntity;
import com.cl.entity.view.WenjuandiaochaView;

import com.cl.service.WenjuandiaochaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 问卷调查
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
@RestController
@RequestMapping("/wenjuandiaocha")
public class WenjuandiaochaController {
    @Autowired
    private WenjuandiaochaService wenjuandiaochaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenjuandiaochaEntity wenjuandiaocha,
		HttpServletRequest request){
        EntityWrapper<WenjuandiaochaEntity> ew = new EntityWrapper<WenjuandiaochaEntity>();

		PageUtils page = wenjuandiaochaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjuandiaocha), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenjuandiaochaEntity wenjuandiaocha, 
		HttpServletRequest request){
        EntityWrapper<WenjuandiaochaEntity> ew = new EntityWrapper<WenjuandiaochaEntity>();

		PageUtils page = wenjuandiaochaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjuandiaocha), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenjuandiaochaEntity wenjuandiaocha){
       	EntityWrapper<WenjuandiaochaEntity> ew = new EntityWrapper<WenjuandiaochaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenjuandiaocha, "wenjuandiaocha")); 
        return R.ok().put("data", wenjuandiaochaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenjuandiaochaEntity wenjuandiaocha){
        EntityWrapper< WenjuandiaochaEntity> ew = new EntityWrapper< WenjuandiaochaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenjuandiaocha, "wenjuandiaocha")); 
		WenjuandiaochaView wenjuandiaochaView =  wenjuandiaochaService.selectView(ew);
		return R.ok("查询问卷调查成功").put("data", wenjuandiaochaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenjuandiaochaEntity wenjuandiaocha = wenjuandiaochaService.selectById(id);
		wenjuandiaocha = wenjuandiaochaService.selectView(new EntityWrapper<WenjuandiaochaEntity>().eq("id", id));
        return R.ok().put("data", wenjuandiaocha);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenjuandiaochaEntity wenjuandiaocha = wenjuandiaochaService.selectById(id);
		wenjuandiaocha = wenjuandiaochaService.selectView(new EntityWrapper<WenjuandiaochaEntity>().eq("id", id));
        return R.ok().put("data", wenjuandiaocha);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenjuandiaochaEntity wenjuandiaocha, HttpServletRequest request){
    	wenjuandiaocha.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjuandiaocha);
        wenjuandiaochaService.insert(wenjuandiaocha);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenjuandiaochaEntity wenjuandiaocha, HttpServletRequest request){
    	wenjuandiaocha.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjuandiaocha);
        wenjuandiaochaService.insert(wenjuandiaocha);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenjuandiaochaEntity wenjuandiaocha, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenjuandiaocha);
        wenjuandiaochaService.updateById(wenjuandiaocha);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenjuandiaochaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
