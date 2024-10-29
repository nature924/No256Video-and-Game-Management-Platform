package com.dao;

import com.entity.YouxixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxixinxiVO;
import com.entity.view.YouxixinxiView;


/**
 * 游戏信息
 * 
 * @author 
 * @email 
 * @date 2023-04-17 12:06:34
 */
public interface YouxixinxiDao extends BaseMapper<YouxixinxiEntity> {
	
	List<YouxixinxiVO> selectListVO(@Param("ew") Wrapper<YouxixinxiEntity> wrapper);
	
	YouxixinxiVO selectVO(@Param("ew") Wrapper<YouxixinxiEntity> wrapper);
	
	List<YouxixinxiView> selectListView(@Param("ew") Wrapper<YouxixinxiEntity> wrapper);

	List<YouxixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YouxixinxiEntity> wrapper);
	
	YouxixinxiView selectView(@Param("ew") Wrapper<YouxixinxiEntity> wrapper);
	

}
