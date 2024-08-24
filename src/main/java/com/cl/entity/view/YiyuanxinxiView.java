package com.cl.entity.view;

import com.cl.entity.YiyuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 医院信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("yiyuanxinxi")
public class YiyuanxinxiView  extends YiyuanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiyuanxinxiView(){
	}
 
 	public YiyuanxinxiView(YiyuanxinxiEntity yiyuanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yiyuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
