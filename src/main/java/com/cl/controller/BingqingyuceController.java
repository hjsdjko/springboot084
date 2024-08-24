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

import com.cl.entity.BingqingyuceEntity;
import com.cl.entity.view.BingqingyuceView;

import com.cl.service.BingqingyuceService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 病情预测
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@RestController
@RequestMapping("/bingqingyuce")
public class BingqingyuceController {
    @Autowired
    private BingqingyuceService bingqingyuceService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BingqingyuceEntity bingqingyuce,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequjumin")) {
			bingqingyuce.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BingqingyuceEntity> ew = new EntityWrapper<BingqingyuceEntity>();

		PageUtils page = bingqingyuceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bingqingyuce), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BingqingyuceEntity bingqingyuce, 
		HttpServletRequest request){
        EntityWrapper<BingqingyuceEntity> ew = new EntityWrapper<BingqingyuceEntity>();

		PageUtils page = bingqingyuceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bingqingyuce), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BingqingyuceEntity bingqingyuce){
       	EntityWrapper<BingqingyuceEntity> ew = new EntityWrapper<BingqingyuceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( bingqingyuce, "bingqingyuce")); 
        return R.ok().put("data", bingqingyuceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BingqingyuceEntity bingqingyuce){
        EntityWrapper< BingqingyuceEntity> ew = new EntityWrapper< BingqingyuceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( bingqingyuce, "bingqingyuce")); 
		BingqingyuceView bingqingyuceView =  bingqingyuceService.selectView(ew);
		return R.ok("查询病情预测成功").put("data", bingqingyuceView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BingqingyuceEntity bingqingyuce = bingqingyuceService.selectById(id);
		bingqingyuce = bingqingyuceService.selectView(new EntityWrapper<BingqingyuceEntity>().eq("id", id));
        return R.ok().put("data", bingqingyuce);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BingqingyuceEntity bingqingyuce = bingqingyuceService.selectById(id);
		bingqingyuce = bingqingyuceService.selectView(new EntityWrapper<BingqingyuceEntity>().eq("id", id));
        return R.ok().put("data", bingqingyuce);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BingqingyuceEntity bingqingyuce, HttpServletRequest request){
    	bingqingyuce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bingqingyuce);
        bingqingyuceService.insert(bingqingyuce);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BingqingyuceEntity bingqingyuce, HttpServletRequest request){
    	bingqingyuce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(bingqingyuce);
        bingqingyuceService.insert(bingqingyuce);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BingqingyuceEntity bingqingyuce, HttpServletRequest request){
        //ValidatorUtils.validateEntity(bingqingyuce);
        bingqingyuceService.updateById(bingqingyuce);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        bingqingyuceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
