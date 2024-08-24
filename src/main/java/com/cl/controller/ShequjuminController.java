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

import com.cl.entity.ShequjuminEntity;
import com.cl.entity.view.ShequjuminView;

import com.cl.service.ShequjuminService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 社区居民
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 12:47:26
 */
@RestController
@RequestMapping("/shequjumin")
public class ShequjuminController {
    @Autowired
    private ShequjuminService shequjuminService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ShequjuminEntity u = shequjuminService.selectOne(new EntityWrapper<ShequjuminEntity>().eq("juminzhanghao", username));
        if(u==null || !u.getJuminmima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"shequjumin",  "社区居民" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShequjuminEntity shequjumin){
    	//ValidatorUtils.validateEntity(shequjumin);
    	ShequjuminEntity u = shequjuminService.selectOne(new EntityWrapper<ShequjuminEntity>().eq("juminzhanghao", shequjumin.getJuminzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		shequjumin.setId(uId);
        shequjuminService.insert(shequjumin);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ShequjuminEntity u = shequjuminService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ShequjuminEntity u = shequjuminService.selectOne(new EntityWrapper<ShequjuminEntity>().eq("juminzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setJuminmima("123456");
        shequjuminService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequjuminEntity shequjumin,
		HttpServletRequest request){
        EntityWrapper<ShequjuminEntity> ew = new EntityWrapper<ShequjuminEntity>();

		PageUtils page = shequjuminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequjumin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequjuminEntity shequjumin, 
		HttpServletRequest request){
        EntityWrapper<ShequjuminEntity> ew = new EntityWrapper<ShequjuminEntity>();

		PageUtils page = shequjuminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequjumin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequjuminEntity shequjumin){
       	EntityWrapper<ShequjuminEntity> ew = new EntityWrapper<ShequjuminEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequjumin, "shequjumin")); 
        return R.ok().put("data", shequjuminService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequjuminEntity shequjumin){
        EntityWrapper< ShequjuminEntity> ew = new EntityWrapper< ShequjuminEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequjumin, "shequjumin")); 
		ShequjuminView shequjuminView =  shequjuminService.selectView(ew);
		return R.ok("查询社区居民成功").put("data", shequjuminView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequjuminEntity shequjumin = shequjuminService.selectById(id);
		shequjumin = shequjuminService.selectView(new EntityWrapper<ShequjuminEntity>().eq("id", id));
        return R.ok().put("data", shequjumin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShequjuminEntity shequjumin = shequjuminService.selectById(id);
		shequjumin = shequjuminService.selectView(new EntityWrapper<ShequjuminEntity>().eq("id", id));
        return R.ok().put("data", shequjumin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequjuminEntity shequjumin, HttpServletRequest request){
    	shequjumin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequjumin);
    	ShequjuminEntity u = shequjuminService.selectOne(new EntityWrapper<ShequjuminEntity>().eq("juminzhanghao", shequjumin.getJuminzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		shequjumin.setId(new Date().getTime());
        shequjuminService.insert(shequjumin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShequjuminEntity shequjumin, HttpServletRequest request){
    	shequjumin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequjumin);
    	ShequjuminEntity u = shequjuminService.selectOne(new EntityWrapper<ShequjuminEntity>().eq("juminzhanghao", shequjumin.getJuminzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		shequjumin.setId(new Date().getTime());
        shequjuminService.insert(shequjumin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequjuminEntity shequjumin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequjumin);
        shequjuminService.updateById(shequjumin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequjuminService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
