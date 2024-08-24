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
 * 体检预约
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("tijianyuyue")
public class TijianyuyueEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TijianyuyueEntity() {
		
	}
	
	public TijianyuyueEntity(T t) {
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
	 * 体检项目
	 */
					
	private String tijianxiangmu;
	
	/**
	 * 体检类型
	 */
					
	private String tijianleixing;
	
	/**
	 * 所属医院
	 */
					
	private String suoshuyiyuan;
	
	/**
	 * 体检地点
	 */
					
	private String tijiandidian;
	
	/**
	 * 体检时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date tijianshijian;
	
	/**
	 * 居民账号
	 */
					
	private String juminzhanghao;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
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
	 * 设置：体检项目
	 */
	public void setTijianxiangmu(String tijianxiangmu) {
		this.tijianxiangmu = tijianxiangmu;
	}
	/**
	 * 获取：体检项目
	 */
	public String getTijianxiangmu() {
		return tijianxiangmu;
	}
	/**
	 * 设置：体检类型
	 */
	public void setTijianleixing(String tijianleixing) {
		this.tijianleixing = tijianleixing;
	}
	/**
	 * 获取：体检类型
	 */
	public String getTijianleixing() {
		return tijianleixing;
	}
	/**
	 * 设置：所属医院
	 */
	public void setSuoshuyiyuan(String suoshuyiyuan) {
		this.suoshuyiyuan = suoshuyiyuan;
	}
	/**
	 * 获取：所属医院
	 */
	public String getSuoshuyiyuan() {
		return suoshuyiyuan;
	}
	/**
	 * 设置：体检地点
	 */
	public void setTijiandidian(String tijiandidian) {
		this.tijiandidian = tijiandidian;
	}
	/**
	 * 获取：体检地点
	 */
	public String getTijiandidian() {
		return tijiandidian;
	}
	/**
	 * 设置：体检时间
	 */
	public void setTijianshijian(Date tijianshijian) {
		this.tijianshijian = tijianshijian;
	}
	/**
	 * 获取：体检时间
	 */
	public Date getTijianshijian() {
		return tijianshijian;
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
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
