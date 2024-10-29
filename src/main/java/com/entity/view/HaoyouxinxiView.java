package com.entity.view;

import com.entity.HaoyouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 好友信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
@TableName("haoyouxinxi")
public class HaoyouxinxiView  extends HaoyouxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HaoyouxinxiView(){
	}
 
 	public HaoyouxinxiView(HaoyouxinxiEntity haoyouxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, haoyouxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
