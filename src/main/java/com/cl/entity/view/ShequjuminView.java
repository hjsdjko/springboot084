package com.cl.entity.view;

import com.cl.entity.ShequjuminEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 社区居民
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:26
 */
@TableName("shequjumin")
public class ShequjuminView  extends ShequjuminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShequjuminView(){
	}
 
 	public ShequjuminView(ShequjuminEntity shequjuminEntity){
 	try {
			BeanUtils.copyProperties(this, shequjuminEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
