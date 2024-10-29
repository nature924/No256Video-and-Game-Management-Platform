package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HaoyouxinxiDao;
import com.entity.HaoyouxinxiEntity;
import com.service.HaoyouxinxiService;
import com.entity.vo.HaoyouxinxiVO;
import com.entity.view.HaoyouxinxiView;

@Service("haoyouxinxiService")
public class HaoyouxinxiServiceImpl extends ServiceImpl<HaoyouxinxiDao, HaoyouxinxiEntity> implements HaoyouxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HaoyouxinxiEntity> page = this.selectPage(
                new Query<HaoyouxinxiEntity>(params).getPage(),
                new EntityWrapper<HaoyouxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HaoyouxinxiEntity> wrapper) {
		  Page<HaoyouxinxiView> page =new Query<HaoyouxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HaoyouxinxiVO> selectListVO(Wrapper<HaoyouxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HaoyouxinxiVO selectVO(Wrapper<HaoyouxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HaoyouxinxiView> selectListView(Wrapper<HaoyouxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HaoyouxinxiView selectView(Wrapper<HaoyouxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
