package com.dao;

import com.entity.HaoyouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HaoyouxinxiVO;
import com.entity.view.HaoyouxinxiView;


/**
 * 好友信息
 * 
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
public interface HaoyouxinxiDao extends BaseMapper<HaoyouxinxiEntity> {
	
	List<HaoyouxinxiVO> selectListVO(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
	
	HaoyouxinxiVO selectVO(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
	
	List<HaoyouxinxiView> selectListView(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);

	List<HaoyouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
	
	HaoyouxinxiView selectView(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
	

}
