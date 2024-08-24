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
 * 问卷回答
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:28
 */
@TableName("wenjuanhuida")
public class WenjuanhuidaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WenjuanhuidaEntity() {
		
	}
	
	public WenjuanhuidaEntity(T t) {
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
	 * 问卷标题
	 */
					
	private String wenjuanbiaoti;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 问题一
	 */
					
	private String wentiyi;
	
	/**
	 * 回答一
	 */
					
	private String huidayi;
	
	/**
	 * 问题二
	 */
					
	private String wentier;
	
	/**
	 * 回答二
	 */
					
	private String huidaer;
	
	/**
	 * 问题三
	 */
					
	private String wentisan;
	
	/**
	 * 回答三
	 */
					
	private String huidasan;
	
	/**
	 * 问题四
	 */
					
	private String wentisi;
	
	/**
	 * 回答四
	 */
					
	private String huidasi;
	
	/**
	 * 问题五
	 */
					
	private String wentiwu;
	
	/**
	 * 回答五
	 */
					
	private String huidawu;
	
	/**
	 * 居民账号
	 */
					
	private String juminzhanghao;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
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
	 * 设置：问卷标题
	 */
	public void setWenjuanbiaoti(String wenjuanbiaoti) {
		this.wenjuanbiaoti = wenjuanbiaoti;
	}
	/**
	 * 获取：问卷标题
	 */
	public String getWenjuanbiaoti() {
		return wenjuanbiaoti;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：问题一
	 */
	public void setWentiyi(String wentiyi) {
		this.wentiyi = wentiyi;
	}
	/**
	 * 获取：问题一
	 */
	public String getWentiyi() {
		return wentiyi;
	}
	/**
	 * 设置：回答一
	 */
	public void setHuidayi(String huidayi) {
		this.huidayi = huidayi;
	}
	/**
	 * 获取：回答一
	 */
	public String getHuidayi() {
		return huidayi;
	}
	/**
	 * 设置：问题二
	 */
	public void setWentier(String wentier) {
		this.wentier = wentier;
	}
	/**
	 * 获取：问题二
	 */
	public String getWentier() {
		return wentier;
	}
	/**
	 * 设置：回答二
	 */
	public void setHuidaer(String huidaer) {
		this.huidaer = huidaer;
	}
	/**
	 * 获取：回答二
	 */
	public String getHuidaer() {
		return huidaer;
	}
	/**
	 * 设置：问题三
	 */
	public void setWentisan(String wentisan) {
		this.wentisan = wentisan;
	}
	/**
	 * 获取：问题三
	 */
	public String getWentisan() {
		return wentisan;
	}
	/**
	 * 设置：回答三
	 */
	public void setHuidasan(String huidasan) {
		this.huidasan = huidasan;
	}
	/**
	 * 获取：回答三
	 */
	public String getHuidasan() {
		return huidasan;
	}
	/**
	 * 设置：问题四
	 */
	public void setWentisi(String wentisi) {
		this.wentisi = wentisi;
	}
	/**
	 * 获取：问题四
	 */
	public String getWentisi() {
		return wentisi;
	}
	/**
	 * 设置：回答四
	 */
	public void setHuidasi(String huidasi) {
		this.huidasi = huidasi;
	}
	/**
	 * 获取：回答四
	 */
	public String getHuidasi() {
		return huidasi;
	}
	/**
	 * 设置：问题五
	 */
	public void setWentiwu(String wentiwu) {
		this.wentiwu = wentiwu;
	}
	/**
	 * 获取：问题五
	 */
	public String getWentiwu() {
		return wentiwu;
	}
	/**
	 * 设置：回答五
	 */
	public void setHuidawu(String huidawu) {
		this.huidawu = huidawu;
	}
	/**
	 * 获取：回答五
	 */
	public String getHuidawu() {
		return huidawu;
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
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
