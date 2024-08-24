package com.cl.entity.view;

import com.cl.entity.JiankangpingjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 健康评级
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 12:47:27
 */
@TableName("jiankangpingji")
public class JiankangpingjiView  extends JiankangpingjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangpingjiView(){
	}
 
 	public JiankangpingjiView(JiankangpingjiEntity jiankangpingjiEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangpingjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
