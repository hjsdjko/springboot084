package com.cl.entity.view;

import com.cl.entity.JiankangdanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 健康档案
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("jiankangdangan")
public class JiankangdanganView  extends JiankangdanganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangdanganView(){
	}
 
 	public JiankangdanganView(JiankangdanganEntity jiankangdanganEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangdanganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
