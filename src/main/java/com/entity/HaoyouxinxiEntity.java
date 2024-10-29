package com.entity;

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
 * 好友信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
@TableName("haoyouxinxi")
public class HaoyouxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HaoyouxinxiEntity() {
		
	}
	
	public HaoyouxinxiEntity(T t) {
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
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
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
