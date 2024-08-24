package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康档案
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("jiankangdangan")
public class JiankangdanganEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangdanganEntity() {
		
	}
	
	public JiankangdanganEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 居民账号
	 */
					
	private String juminzhanghao;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 身高
	 */
					
	private String shengao;
	
	/**
	 * 体重
	 */
					
	private String tizhong;
	
	/**
	 * 血型
	 */
					
	private String xuexing;
	
	/**
	 * 药物过敏
	 */
					
	private String yaowuguomin;
	
	/**
	 * 家族病史
	 */
					
	private String jiazubingshi;
	
	/**
	 * 住院记录
	 */
					
	private String zhuyuanjilu;
	
	/**
	 * 其他详情
	 */
					
	private String qitaxiangqing;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：居民账号
	 */
	public void setJuminzhanghao(String juminzhanghao) {
		this.juminzhanghao = juminzhanghao;
	}
	/**
	 * 获取：居民账号
	 */
	public String getJuminzhanghao() {
		return juminzhanghao;
	}
	/**
	 * 设置：居民姓名
	 */
	public void setJuminxingming(String juminxingming) {
		this.juminxingming = juminxingming;
	}
	/**
	 * 获取：居民姓名
	 */
	public String getJuminxingming() {
		return juminxingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：身高
	 */
	public void setShengao(String shengao) {
		this.shengao = shengao;
	}
	/**
	 * 获取：身高
	 */
	public String getShengao() {
		return shengao;
	}
	/**
	 * 设置：体重
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：血型
	 */
	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}
	/**
	 * 获取：血型
	 */
	public String getXuexing() {
		return xuexing;
	}
	/**
	 * 设置：药物过敏
	 */
	public void setYaowuguomin(String yaowuguomin) {
		this.yaowuguomin = yaowuguomin;
	}
	/**
	 * 获取：药物过敏
	 */
	public String getYaowuguomin() {
		return yaowuguomin;
	}
	/**
	 * 设置：家族病史
	 */
	public void setJiazubingshi(String jiazubingshi) {
		this.jiazubingshi = jiazubingshi;
	}
	/**
	 * 获取：家族病史
	 */
	public String getJiazubingshi() {
		return jiazubingshi;
	}
	/**
	 * 设置：住院记录
	 */
	public void setZhuyuanjilu(String zhuyuanjilu) {
		this.zhuyuanjilu = zhuyuanjilu;
	}
	/**
	 * 获取：住院记录
	 */
	public String getZhuyuanjilu() {
		return zhuyuanjilu;
	}
	/**
	 * 设置：其他详情
	 */
	public void setQitaxiangqing(String qitaxiangqing) {
		this.qitaxiangqing = qitaxiangqing;
	}
	/**
	 * 获取：其他详情
	 */
	public String getQitaxiangqing() {
		return qitaxiangqing;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}

}
