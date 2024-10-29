package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HaoyouxinxiEntity;
import com.entity.view.HaoyouxinxiView;

import com.service.HaoyouxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 好友信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 12:06:35
 */
@RestController
@RequestMapping("/haoyouxinxi")
public class HaoyouxinxiController {
    @Autowired
    private HaoyouxinxiService haoyouxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HaoyouxinxiEntity haoyouxinxi,
		HttpServletRequest request){
        EntityWrapper<HaoyouxinxiEntity> ew = new EntityWrapper<HaoyouxinxiEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("duifangyonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = haoyouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haoyouxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HaoyouxinxiEntity haoyouxinxi, 
		HttpServletRequest request){
        EntityWrapper<HaoyouxinxiEntity> ew = new EntityWrapper<HaoyouxinxiEntity>();

		PageUtils page = haoyouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haoyouxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HaoyouxinxiEntity haoyouxinxi){
       	EntityWrapper<HaoyouxinxiEntity> ew = new EntityWrapper<HaoyouxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( haoyouxinxi, "haoyouxinxi")); 
        return R.ok().put("data", haoyouxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HaoyouxinxiEntity haoyouxinxi){
        EntityWrapper< HaoyouxinxiEntity> ew = new EntityWrapper< HaoyouxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( haoyouxinxi, "haoyouxinxi")); 
		HaoyouxinxiView haoyouxinxiView =  haoyouxinxiService.selectView(ew);
		return R.ok("查询好友信息成功").put("data", haoyouxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HaoyouxinxiEntity haoyouxinxi = haoyouxinxiService.selectById(id);
        return R.ok().put("data", haoyouxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HaoyouxinxiEntity haoyouxinxi = haoyouxinxiService.selectById(id);
        return R.ok().put("data", haoyouxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HaoyouxinxiEntity haoyouxinxi, HttpServletRequest request){
    	haoyouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haoyouxinxi);
        haoyouxinxiService.insert(haoyouxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HaoyouxinxiEntity haoyouxinxi, HttpServletRequest request){
    	haoyouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haoyouxinxi);
        haoyouxinxiService.insert(haoyouxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HaoyouxinxiEntity haoyouxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(haoyouxinxi);
        haoyouxinxiService.updateById(haoyouxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        haoyouxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<HaoyouxinxiEntity> wrapper = new EntityWrapper<HaoyouxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = haoyouxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
