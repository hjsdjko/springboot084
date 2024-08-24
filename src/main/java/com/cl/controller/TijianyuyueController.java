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

import com.cl.entity.TijianyuyueEntity;
import com.cl.entity.view.TijianyuyueView;

import com.cl.service.TijianyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 体检预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@RestController
@RequestMapping("/tijianyuyue")
public class TijianyuyueController {
    @Autowired
    private TijianyuyueService tijianyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TijianyuyueEntity tijianyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequjumin")) {
			tijianyuyue.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TijianyuyueEntity> ew = new EntityWrapper<TijianyuyueEntity>();

		PageUtils page = tijianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TijianyuyueEntity tijianyuyue, 
		HttpServletRequest request){
        EntityWrapper<TijianyuyueEntity> ew = new EntityWrapper<TijianyuyueEntity>();

		PageUtils page = tijianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TijianyuyueEntity tijianyuyue){
       	EntityWrapper<TijianyuyueEntity> ew = new EntityWrapper<TijianyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tijianyuyue, "tijianyuyue")); 
        return R.ok().put("data", tijianyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TijianyuyueEntity tijianyuyue){
        EntityWrapper< TijianyuyueEntity> ew = new EntityWrapper< TijianyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tijianyuyue, "tijianyuyue")); 
		TijianyuyueView tijianyuyueView =  tijianyuyueService.selectView(ew);
		return R.ok("查询体检预约成功").put("data", tijianyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TijianyuyueEntity tijianyuyue = tijianyuyueService.selectById(id);
		tijianyuyue = tijianyuyueService.selectView(new EntityWrapper<TijianyuyueEntity>().eq("id", id));
        return R.ok().put("data", tijianyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TijianyuyueEntity tijianyuyue = tijianyuyueService.selectById(id);
		tijianyuyue = tijianyuyueService.selectView(new EntityWrapper<TijianyuyueEntity>().eq("id", id));
        return R.ok().put("data", tijianyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TijianyuyueEntity tijianyuyue, HttpServletRequest request){
    	tijianyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianyuyue);
        tijianyuyueService.insert(tijianyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TijianyuyueEntity tijianyuyue, HttpServletRequest request){
    	tijianyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianyuyue);
        tijianyuyueService.insert(tijianyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TijianyuyueEntity tijianyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tijianyuyue);
        tijianyuyueService.updateById(tijianyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TijianyuyueEntity> list = new ArrayList<TijianyuyueEntity>();
        for(Long id : ids) {
            TijianyuyueEntity tijianyuyue = tijianyuyueService.selectById(id);
            tijianyuyue.setSfsh(sfsh);
            tijianyuyue.setShhf(shhf);
            list.add(tijianyuyue);
        }
        tijianyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tijianyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
