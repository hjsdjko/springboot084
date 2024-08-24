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

import com.cl.entity.WenjuanhuidaEntity;
import com.cl.entity.view.WenjuanhuidaView;

import com.cl.service.WenjuanhuidaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 问卷回答
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
@RestController
@RequestMapping("/wenjuanhuida")
public class WenjuanhuidaController {
    @Autowired
    private WenjuanhuidaService wenjuanhuidaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenjuanhuidaEntity wenjuanhuida,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequjumin")) {
			wenjuanhuida.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WenjuanhuidaEntity> ew = new EntityWrapper<WenjuanhuidaEntity>();

		PageUtils page = wenjuanhuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjuanhuida), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenjuanhuidaEntity wenjuanhuida, 
		HttpServletRequest request){
        EntityWrapper<WenjuanhuidaEntity> ew = new EntityWrapper<WenjuanhuidaEntity>();

		PageUtils page = wenjuanhuidaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjuanhuida), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenjuanhuidaEntity wenjuanhuida){
       	EntityWrapper<WenjuanhuidaEntity> ew = new EntityWrapper<WenjuanhuidaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenjuanhuida, "wenjuanhuida")); 
        return R.ok().put("data", wenjuanhuidaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenjuanhuidaEntity wenjuanhuida){
        EntityWrapper< WenjuanhuidaEntity> ew = new EntityWrapper< WenjuanhuidaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenjuanhuida, "wenjuanhuida")); 
		WenjuanhuidaView wenjuanhuidaView =  wenjuanhuidaService.selectView(ew);
		return R.ok("查询问卷回答成功").put("data", wenjuanhuidaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenjuanhuidaEntity wenjuanhuida = wenjuanhuidaService.selectById(id);
		wenjuanhuida = wenjuanhuidaService.selectView(new EntityWrapper<WenjuanhuidaEntity>().eq("id", id));
        return R.ok().put("data", wenjuanhuida);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenjuanhuidaEntity wenjuanhuida = wenjuanhuidaService.selectById(id);
		wenjuanhuida = wenjuanhuidaService.selectView(new EntityWrapper<WenjuanhuidaEntity>().eq("id", id));
        return R.ok().put("data", wenjuanhuida);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenjuanhuidaEntity wenjuanhuida, HttpServletRequest request){
    	wenjuanhuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjuanhuida);
        wenjuanhuidaService.insert(wenjuanhuida);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenjuanhuidaEntity wenjuanhuida, HttpServletRequest request){
    	wenjuanhuida.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjuanhuida);
        wenjuanhuidaService.insert(wenjuanhuida);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenjuanhuidaEntity wenjuanhuida, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenjuanhuida);
        wenjuanhuidaService.updateById(wenjuanhuida);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenjuanhuidaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
