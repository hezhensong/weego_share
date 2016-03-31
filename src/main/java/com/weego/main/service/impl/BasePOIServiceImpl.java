package com.weego.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.weego.main.dto.POIDetailSumDto;
import com.weego.main.service.AreaService;
import com.weego.main.service.AttractionService;
import com.weego.main.service.BasePOIService;
import com.weego.main.service.RestaurantService;
import com.weego.main.service.ShoppingService;

@Service("basePOIService")
public class BasePOIServiceImpl implements BasePOIService {

	private static Logger logger = LogManager
			.getLogger(BasePOIServiceImpl.class);

	@Autowired
	AttractionService attractionService;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	ShoppingService shoppingService;
	@Autowired
	AreaService areaService;
	
	@Override
	public ModelAndView getPOIDetail(String id, Integer type) {

		ModelAndView mv = null;
		POIDetailSumDto poiDetailSumDto = new POIDetailSumDto();
		if (type == 0) {
			mv = new ModelAndView("POIspot");
			poiDetailSumDto = attractionService.getAttractionById(id,
					"-73.9991637,40.7536854");
		} else if (type == 1) {
			mv = new ModelAndView("POIfood");
			poiDetailSumDto = restaurantService.getRestaurantById(id,
					"-73.9991637,40.7536854");
		} else if (type == 2) {
			mv = new ModelAndView("POIshop");
			poiDetailSumDto = shoppingService.getShoppingById(id,
					"-73.9991637,40.7536854");
		} else if(type == 3) {
			mv = new ModelAndView("POIshop");
			poiDetailSumDto = areaService.getAreaById(id,
					"-73.9991637,40.7536854");
		} else {
			logger.info("type 参数值有误");
			mv = null;
			poiDetailSumDto = null;
		}

		if (poiDetailSumDto != null) {
				mv.addObject("type", poiDetailSumDto.getType());
				mv.addObject("coverimage", poiDetailSumDto.getCoverImage());
				mv.addObject("title", poiDetailSumDto.getName());
				mv.addObject("english_title", "");
				mv.addObject("reviews", poiDetailSumDto.getRating());
				mv.addObject("foreword", poiDetailSumDto.getBriefIntroduction());
				// 需要循环的tag
				mv.addObject("tags", poiDetailSumDto.getTag());
				
				mv.addObject("breif", poiDetailSumDto.getIntroduction());
				mv.addObject("tips", poiDetailSumDto.getTips());

				// 菜品推荐循环遍历
				mv.addObject("recommends", poiDetailSumDto.getSpecial());

				mv.addObject("commentFrom", poiDetailSumDto.getCommentFrom());
				// 评论
				if (poiDetailSumDto.getComments() != null && poiDetailSumDto.getComments().size() > 0) {
					mv.addObject("comments", poiDetailSumDto.getComments().get(0));
				} else {
					mv.addObject("comments", null);
				}

				// 后面一段
				mv.addObject("price", poiDetailSumDto.getPriceDesc());
				mv.addObject("phone", poiDetailSumDto.getTel());
				mv.addObject("web", poiDetailSumDto.getWebsite());
				// 营业时间是列表形式的
				mv.addObject("times", poiDetailSumDto.getOpenTime());
				// 设施，需要循环遍历，传的是一个对象，里面的值是true or false
				mv.addObject("facilitie", poiDetailSumDto.getFacilities());

				return mv;
			} else {
				logger.info("通过id找不到相应的POI");
				return null;
			}
	}

}
