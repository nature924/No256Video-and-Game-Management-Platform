package com.entity.vo;

import com.entity.HaoyouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 好友信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
public class HaoyouxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 添加时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tianjiashijian;
		
	/**
	 * 对方用户账号
	 */
	
	private String duifangyonghuzhanghao;
		
	/**
	 * 对方用户姓名
	 */
	
	private String duifangyonghuxingming;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
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
	 * 设置：添加时间
	 */
	 
	public void setTianjiashijian(Date tianjiashijian) {
		this.tianjiashijian = tianjiashijian;
	}
	
	/**
	 * 获取：添加时间
	 */
	public Date getTianjiashijian() {
		return tianjiashijian;
	}
				
	
	/**
	 * 设置：对方用户账号
	 */
	 
	public void setDuifangyonghuzhanghao(String duifangyonghuzhanghao) {
		this.duifangyonghuzhanghao = duifangyonghuzhanghao;
	}
	
	/**
	 * 获取：对方用户账号
	 */
	public String getDuifangyonghuzhanghao() {
		return duifangyonghuzhanghao;
	}
				
	
	/**
	 * 设置：对方用户姓名
	 */
	 
	public void setDuifangyonghuxingming(String duifangyonghuxingming) {
		this.duifangyonghuxingming = duifangyonghuxingming;
	}
	
	/**
	 * 获取：对方用户姓名
	 */
	public String getDuifangyonghuxingming() {
		return duifangyonghuxingming;
	}
			
}
