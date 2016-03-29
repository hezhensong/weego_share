package com.weego.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weego.main.dao.ActivityDao;
import com.weego.main.dao.RestaurantDao;
import com.weego.main.dto.POIDetailActivitiesDto;
import com.weego.main.dto.POIDetailCommentsDto;
import com.weego.main.dto.POIDetailFacilitiesDto;
import com.weego.main.dto.POIDetailSpecialDto;
import com.weego.main.dto.POIDetailSumDto;
import com.weego.main.dto.POIDetailTagDto;
import com.weego.main.model.BasePOIComments;
import com.weego.main.model.BasePOIOpenTime;
import com.weego.main.model.RestaurantDish;
import com.weego.main.model.RestaurantInfo;
import com.weego.main.model.Restaurants;
import com.weego.main.service.RestaurantService;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	private static Logger logger = LogManager.getLogger(RestaurantServiceImpl.class);
	private String imageUrl = "http://weegotest.b0.upaiyun.com/restaurant/iosimgs/";
	
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	ActivityDao activityDao;

	@Override
	public POIDetailSumDto getRestaurantById(String id, String coordination) {
		POIDetailSumDto poiDetailSumDto = new POIDetailSumDto();
		
		try {
			Restaurants restaurant = restaurantDao.getRestaurantById(id);
			if (restaurant != null) {
				poiDetailSumDto.setId(restaurant.getId());
				poiDetailSumDto.setType(Integer.parseInt(restaurant.getType()));
				poiDetailSumDto.setName(restaurant.getName());
				poiDetailSumDto.setNameEn(restaurant.getNameEn());
				poiDetailSumDto.setAddress(restaurant.getAddress());
				poiDetailSumDto.setTel(restaurant.getTel());
				poiDetailSumDto.setWebsite(restaurant.getWebsite());
				poiDetailSumDto.setBriefIntroduction(restaurant.getBriefIntroduce());
				poiDetailSumDto.setIntroduction(restaurant.getIntroduce());
				poiDetailSumDto.setCityName(restaurant.getCityName());
				poiDetailSumDto.setCityId(restaurant.getCityId());

				poiDetailSumDto.setImage(restaurant.getImage());
				poiDetailSumDto.setCoverImage(imageUrl + restaurant.getCoverImage());
				
				List<BasePOIOpenTime> openTimes = restaurant.getOpenTime();
				List<String> openTimeDesc = new ArrayList<String>();
				if(openTimes != null && openTimes.size() > 0) {
					for(BasePOIOpenTime openTime : openTimes) {
						openTimeDesc.add(openTime.getDesc());
					}
					poiDetailSumDto.setOpenTime(openTimeDesc);
				}
				
				poiDetailSumDto.setPriceDesc(restaurant.getPriceDesc());
				poiDetailSumDto.setRating(Double.parseDouble(String.valueOf(restaurant.getRating())));

				List<POIDetailSpecialDto> poiDetailSpecialDtos = new ArrayList<POIDetailSpecialDto>();
				List<RestaurantDish> restaurantDishs = restaurant.getMenu();
				if (restaurantDishs != null && restaurantDishs.size() > 0) {
					for (RestaurantDish restaurantDish : restaurantDishs) {
						POIDetailSpecialDto poiDetailSpecialDto = new POIDetailSpecialDto();
						poiDetailSpecialDto.setId("");
						poiDetailSpecialDto.setAdvice(restaurantDish.getAdvice());
						poiDetailSpecialDto.setDesc(restaurantDish.getDesc());
						poiDetailSpecialDto.setTitle("");
						poiDetailSpecialDto.setTag("");
						poiDetailSpecialDto.setCoverImage(imageUrl + restaurantDish.getCoverImage());
						poiDetailSpecialDtos.add(poiDetailSpecialDto);
					}
				}
				poiDetailSumDto.setSpecial(poiDetailSpecialDtos);

				List<POIDetailActivitiesDto> poiDetailActivitiesDtos = new ArrayList<POIDetailActivitiesDto>();
				poiDetailSumDto.setActivities(poiDetailActivitiesDtos);

				List<POIDetailTagDto> poiDetailTagDtos = new ArrayList<POIDetailTagDto>();
				List<String> basePOITags = restaurant.getTagsZh();
				if (basePOITags != null && basePOITags.size() > 0) {
					for (String basePOITag : basePOITags) {
						POIDetailTagDto poiDetailTagDto = new POIDetailTagDto();
						poiDetailTagDto.setId("");
						poiDetailTagDto.setName(basePOITag);
						poiDetailTagDtos.add(poiDetailTagDto);
					}
				}
				poiDetailSumDto.setTag(poiDetailTagDtos);

				poiDetailSumDto.setTips(restaurant.getTips());
				poiDetailSumDto.setCommentsUrl(restaurant.getCommentsUrl());
				poiDetailSumDto.setCommentFrom(restaurant.getCommentsFrom());

				List<POIDetailCommentsDto> poiDetailCommentsDtos = new ArrayList<POIDetailCommentsDto>();
				List<BasePOIComments> basePOIComments = restaurant.getComments();
				if (basePOIComments != null && basePOIComments.size() > 0) {
					for (BasePOIComments basePOIComment : basePOIComments) {
						POIDetailCommentsDto poiDetailCommentsDto = new POIDetailCommentsDto();
						poiDetailCommentsDto.setNickname(basePOIComment.getNickname());
						if(basePOIComment.getDate() != null) {
							poiDetailCommentsDto.setDate(basePOIComment.getDate());
						}
						poiDetailCommentsDto.setText(basePOIComment.getText());
						poiDetailCommentsDto.setRating(basePOIComment.getRating());
						poiDetailCommentsDto.setTitle(basePOIComment.getTitle());
						poiDetailCommentsDto.setLanguage(basePOIComment
								.getLanguage());
						poiDetailCommentsDtos.add(poiDetailCommentsDto);
					}
				}
				poiDetailSumDto.setComments(poiDetailCommentsDtos);
				poiDetailSumDto.setOpenTableUrl(restaurant.getOpenTabelUrl());
				poiDetailSumDto.setOpenDay(0);

				POIDetailFacilitiesDto poiDetailFacilitiesDto = new POIDetailFacilitiesDto();
				RestaurantInfo restaurantFacilities = restaurant.getInfo();
				if (restaurantFacilities != null) {
					poiDetailFacilitiesDto.setAlcohol(restaurantFacilities
							.getAlcohol());
					poiDetailFacilitiesDto
							.setNoise(restaurantFacilities.getNoise());
					poiDetailFacilitiesDto.setWaiter(restaurantFacilities
							.isWaiter());
					poiDetailFacilitiesDto.setTv(restaurantFacilities.isTv());
					poiDetailFacilitiesDto.setOutseat(restaurantFacilities
							.isOutseat());
					poiDetailFacilitiesDto.setGroup(restaurantFacilities.isGroup());
					poiDetailFacilitiesDto.setKid(restaurantFacilities.isKid());
					poiDetailFacilitiesDto.setCard(restaurantFacilities.isCard());
					poiDetailFacilitiesDto.setTakeout(restaurantFacilities
							.isTakeout());
					poiDetailFacilitiesDto.setDelivery(restaurantFacilities
							.isDelivery());
					poiDetailFacilitiesDto.setReserve(restaurantFacilities
							.isReserve());
					poiDetailFacilitiesDto.setWifi(restaurantFacilities.isWifi());
				}

				poiDetailSumDto.setFacilities(poiDetailFacilitiesDto);
			}
		} catch (Exception e) {
			logger.info("探索城市餐厅详情页出错!");
			e.printStackTrace();
		}
		return poiDetailSumDto;
	}
}
