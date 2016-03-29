package com.weego.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weego.main.dao.ActivityDao;
import com.weego.main.dao.ShoppingDao;
import com.weego.main.dto.POIDetailActivitiesDto;
import com.weego.main.dto.POIDetailCommentsDto;
import com.weego.main.dto.POIDetailSpecialDto;
import com.weego.main.dto.POIDetailSumDto;
import com.weego.main.model.BasePOIComments;
import com.weego.main.model.BasePOIOpenTime;
import com.weego.main.model.ShoppingBrand;
import com.weego.main.model.Shoppings;
import com.weego.main.service.ShoppingService;

@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {

	private static Logger logger = LogManager.getLogger(ShoppingServiceImpl.class);
	private String imageUrl = "http://weegotest.b0.upaiyun.com/shopping/iosimgs/";
	
	@Autowired
	ShoppingDao shoppingDao;
	@Autowired
	ActivityDao activityDao;


	@Override
	public POIDetailSumDto getShoppingById(String id, String coordination) {
		POIDetailSumDto poiDetailSumDto = new POIDetailSumDto();
		
		try {
			Shoppings shopping = shoppingDao.getShoppingById(id);
			if (shopping != null) {
				poiDetailSumDto.setId(shopping.getId());
				poiDetailSumDto.setType(Integer.parseInt(shopping.getType()));
				poiDetailSumDto.setName(shopping.getName());
				poiDetailSumDto.setNameEn(shopping.getNameEn());
				poiDetailSumDto.setAddress(shopping.getAddress());
				poiDetailSumDto.setTel(shopping.getTel());
				poiDetailSumDto.setWebsite(shopping.getUrl());
				poiDetailSumDto.setBriefIntroduction("");
				poiDetailSumDto.setIntroduction(shopping.getIntroduce());
				poiDetailSumDto.setCityName(shopping.getCityName());
				poiDetailSumDto.setCityId(shopping.getCityId());

				poiDetailSumDto.setImage(shopping.getImage());
				poiDetailSumDto.setCoverImage(imageUrl + shopping.getCoverImage());
				
				List<BasePOIOpenTime> openTimes = shopping.getOpenTime();
				List<String> openTimeDesc = new ArrayList<String>();
				if(openTimes != null && openTimes.size() > 0) {
					for(BasePOIOpenTime openTime : openTimes) {
						openTimeDesc.add(openTime.getDesc());
					}
					poiDetailSumDto.setOpenTime(openTimeDesc);
				}
				
				poiDetailSumDto.setPriceDesc(shopping.getPriceDesc());
				poiDetailSumDto.setRating(Double.parseDouble(String.valueOf(shopping.getRating())));

				List<POIDetailSpecialDto> poiDetailSpecialDtos = new ArrayList<POIDetailSpecialDto>();
				List<ShoppingBrand> shoppingBrands = shopping.getBrand();
				if (shoppingBrands != null && shoppingBrands.size() > 0) {
					for (ShoppingBrand shoppingBrand : shoppingBrands) {
						POIDetailSpecialDto poiDetailSpecialDto = new POIDetailSpecialDto();
						poiDetailSpecialDto.setId(shoppingBrand.getId());
						poiDetailSpecialDto.setAdvice("");
						poiDetailSpecialDto.setDesc(shoppingBrand.getDesc());
						poiDetailSpecialDto.setTitle(shoppingBrand.getTitle());
						poiDetailSpecialDto.setTag("");
						poiDetailSpecialDto.setCoverImage(imageUrl + shoppingBrand.getCoverImage());
						poiDetailSpecialDtos.add(poiDetailSpecialDto);
					}
				}
				poiDetailSumDto.setSpecial(poiDetailSpecialDtos);

				List<POIDetailActivitiesDto> poiDetailActivitiesDtos = new ArrayList<POIDetailActivitiesDto>();
				poiDetailSumDto.setActivities(poiDetailActivitiesDtos);

				/*List<POIDetailTagDto> poiDetailTagDtos = new ArrayList<POIDetailTagDto>();
				List<BasePOITag> basePOITags = shopping.getSubTag();
				if (basePOITags != null && basePOITags.size() > 0) {
					for (BasePOITag basePOITag : basePOITags) {
						POIDetailTagDto poiDetailTagDto = new POIDetailTagDto();
						poiDetailTagDto.setId(basePOITag.getId());
						poiDetailTagDto.setName(basePOITag.getTag());
						poiDetailTagDtos.add(poiDetailTagDto);
					}
				}*/
				poiDetailSumDto.setTag(null);

				poiDetailSumDto.setTips(shopping.getTips());
				poiDetailSumDto.setCommentsUrl("");
				poiDetailSumDto.setCommentFrom("");

				List<POIDetailCommentsDto> poiDetailCommentsDtos = new ArrayList<POIDetailCommentsDto>();
				List<BasePOIComments> basePOIComments = shopping.getComments();
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
				poiDetailSumDto.setOpenTableUrl("");
				poiDetailSumDto.setOpenDay(0);

				poiDetailSumDto.setFacilities(null);
			}
		} catch (Exception e) {
			logger.info("探索城市购物详情页出错!");
			e.printStackTrace();
		}
		return poiDetailSumDto;
	}

}
