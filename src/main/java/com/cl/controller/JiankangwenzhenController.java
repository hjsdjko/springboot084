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

import com.cl.entity.JiankangwenzhenEntity;
import com.cl.entity.view.JiankangwenzhenView;

import com.cl.service.JiankangwenzhenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康问诊
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@RestController
@RequestMapping("/jiankangwenzhen")
public class JiankangwenzhenController {
    @Autowired
    private JiankangwenzhenService jiankangwenzhenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangwenzhenEntity jiankangwenzhen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			jiankangwenzhen.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shequjumin")) {
			jiankangwenzhen.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangwenzhenEntity> ew = new EntityWrapper<JiankangwenzhenEntity>();

		PageUtils page = jiankangwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangwenzhenEntity jiankangwenzhen, 
		HttpServletRequest request){
        EntityWrapper<JiankangwenzhenEntity> ew = new EntityWrapper<JiankangwenzhenEntity>();

		PageUtils page = jiankangwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangwenzhenEntity jiankangwenzhen){
       	EntityWrapper<JiankangwenzhenEntity> ew = new EntityWrapper<JiankangwenzhenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangwenzhen, "jiankangwenzhen")); 
        return R.ok().put("data", jiankangwenzhenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangwenzhenEntity jiankangwenzhen){
        EntityWrapper< JiankangwenzhenEntity> ew = new EntityWrapper< JiankangwenzhenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangwenzhen, "jiankangwenzhen")); 
		JiankangwenzhenView jiankangwenzhenView =  jiankangwenzhenService.selectView(ew);
		return R.ok("查询健康问诊成功").put("data", jiankangwenzhenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangwenzhenEntity jiankangwenzhen = jiankangwenzhenService.selectById(id);
		jiankangwenzhen = jiankangwenzhenService.selectView(new EntityWrapper<JiankangwenzhenEntity>().eq("id", id));
        return R.ok().put("data", jiankangwenzhen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangwenzhenEntity jiankangwenzhen = jiankangwenzhenService.selectById(id);
		jiankangwenzhen = jiankangwenzhenService.selectView(new EntityWrapper<JiankangwenzhenEntity>().eq("id", id));
        return R.ok().put("data", jiankangwenzhen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangwenzhenEntity jiankangwenzhen, HttpServletRequest request){
    	jiankangwenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangwenzhen);
        jiankangwenzhenService.insert(jiankangwenzhen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangwenzhenEntity jiankangwenzhen, HttpServletRequest request){
    	jiankangwenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangwenzhen);
        jiankangwenzhenService.insert(jiankangwenzhen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangwenzhenEntity jiankangwenzhen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangwenzhen);
        jiankangwenzhenService.updateById(jiankangwenzhen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangwenzhenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
