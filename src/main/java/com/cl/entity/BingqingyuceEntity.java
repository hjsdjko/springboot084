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
 * 病情预测
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("bingqingyuce")
public class BingqingyuceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BingqingyuceEntity() {
		
	}
	
	public BingqingyuceEntity(T t) {
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
	 * 病情情况
	 */
					
	private String bingqingqingkuang;
	
	/**
	 * 诊断信息
	 */
					
	private String zhenduanxinxi;
	
	/**
	 * 治疗信息
	 */
					
	private String zhiliaoxinxi;
	
	/**
	 * 预后信息
	 */
					
	private String yuhouxinxi;
	
	/**
	 * 日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date riqi;
	
	
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
	 * 设置：病情情况
	 */
	public void setBingqingqingkuang(String bingqingqingkuang) {
		this.bingqingqingkuang = bingqingqingkuang;
	}
	/**
	 * 获取：病情情况
	 */
	public String getBingqingqingkuang() {
		return bingqingqingkuang;
	}
	/**
	 * 设置：诊断信息
	 */
	public void setZhenduanxinxi(String zhenduanxinxi) {
		this.zhenduanxinxi = zhenduanxinxi;
	}
	/**
	 * 获取：诊断信息
	 */
	public String getZhenduanxinxi() {
		return zhenduanxinxi;
	}
	/**
	 * 设置：治疗信息
	 */
	public void setZhiliaoxinxi(String zhiliaoxinxi) {
		this.zhiliaoxinxi = zhiliaoxinxi;
	}
	/**
	 * 获取：治疗信息
	 */
	public String getZhiliaoxinxi() {
		return zhiliaoxinxi;
	}
	/**
	 * 设置：预后信息
	 */
	public void setYuhouxinxi(String yuhouxinxi) {
		this.yuhouxinxi = yuhouxinxi;
	}
	/**
	 * 获取：预后信息
	 */
	public String getYuhouxinxi() {
		return yuhouxinxi;
	}
	/**
	 * 设置：日期
	 */
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}

}
