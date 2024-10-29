package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HaoyouxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HaoyouxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HaoyouxinxiView;


/**
 * 好友信息
 *
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
public interface HaoyouxinxiService extends IService<HaoyouxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaoyouxinxiVO> selectListVO(Wrapper<HaoyouxinxiEntity> wrapper);
   	
   	HaoyouxinxiVO selectVO(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
   	
   	List<HaoyouxinxiView> selectListView(Wrapper<HaoyouxinxiEntity> wrapper);
   	
   	HaoyouxinxiView selectView(@Param("ew") Wrapper<HaoyouxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaoyouxinxiEntity> wrapper);
   	

}

