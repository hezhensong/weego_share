package com.weego.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;
import com.weego.main.dao.AreaDao;
import com.weego.main.dao.AttractionDao;
import com.weego.main.dao.PeopleDao;
import com.weego.main.dao.PgcDao;
import com.weego.main.dao.RestaurantDao;
import com.weego.main.dao.ShoppingDao;
import com.weego.main.dto.ParagraphDto;
import com.weego.main.dto.PgcContentDto;
import com.weego.main.dto.PgcImageDto;
import com.weego.main.dto.PgcPoiDto;
import com.weego.main.model.Areas;
import com.weego.main.model.BasePOILabel;
import com.weego.main.model.LatestAttractions;
import com.weego.main.model.Peoples;
import com.weego.main.model.PgcPoi;
import com.weego.main.model.Pgcs;
import com.weego.main.model.Restaurants;
import com.weego.main.service.PgcService;

@Service("pgcService")
public class PgcServiceImpl implements PgcService {

	@Autowired
	private PgcDao pgcDao;

	@Autowired
	private PeopleDao peopleDao;

	@Autowired
	private AttractionDao attractionDao;

	@Autowired
	private RestaurantDao restaurantDao;

	@Autowired
	private ShoppingDao shoppingDao;

	@Autowired
	private AreaDao areaDao;

	@Override
	public ModelAndView getSpecifiedPgc(String pgcId) {

		Pgcs pgc = pgcDao.getSpecifiedPgc(pgcId);
		if (pgc == null) {
			return null;
		} else {

			ModelAndView mv = new ModelAndView("PGC");
			mv.addObject("author", pgc.getPgcPeople().getName());
			mv.addObject("poi_bg", pgc.getCoverImage());
			mv.addObject("title", pgc.getTitle());

			if (Strings.isNullOrEmpty(pgc.getPgcPeople().getName())) {
				mv.addObject("person", null);
			} else {
				Peoples person = peopleDao.getPeopleById(pgc.getPgcPeople().getId());
				if (person != null) {
					mv.addObject("person", person);
				} else {
					mv.addObject("person", null);
				}
			}

			mv.addObject("original", null);

			List<PgcPoi> pgcPoiList = pgc.getPgcPoi();
			List<PgcContentDto> pgcPoiDtoList = new ArrayList<PgcContentDto>();
			if (pgcPoiList != null && pgcPoiList.size() > 0) {
				for (PgcPoi pgcPoi : pgcPoiList) {
					PgcContentDto pgcContentDto = new PgcContentDto();
					ParagraphDto paragraphDto = new ParagraphDto();
					paragraphDto.setTitle(Strings.nullToEmpty(""));
					paragraphDto.setDesc(Strings.nullToEmpty(""));
					pgcContentDto.setParagraph(paragraphDto);

					PgcPoiDto pgcPoiDto = new PgcPoiDto();
					pgcPoiDto.setId(Strings.nullToEmpty(pgcPoi.getId()));
					pgcPoiDto
							.setImage(Strings.nullToEmpty(pgcPoi.getPoiImage()));
					pgcPoiDto.setType(Strings.nullToEmpty(pgcPoi.getType()));
					pgcPoiDto.setTitle(Strings.nullToEmpty(pgcPoi.getName()));
					String tag = getPoiTagbyType(pgcPoi.getId(), pgcPoi.getType());
					/*if (tag == null || tag.endsWith("")) {
						pgcPoiDto.setTag(tag);
					}*/
					
					pgcPoiDto.setTag(tag);
					pgcContentDto.setPoi(pgcPoiDto);

					PgcImageDto pgcImageDto = new PgcImageDto();
					
					/*pgcImageDto.setUrl(Strings.nullToEmpty(pgcPoi.getImageUrl())); 
					pgcImageDto.setSource(Strings.nullToEmpty(pgcPoi.getImageSource()));*/
					 
					pgcContentDto.setImage(pgcImageDto);

					pgcPoiDtoList.add(pgcContentDto);
				}
			}
			mv.addObject("poilist", pgcPoiDtoList);
			mv.addObject("breif", pgc.getIntroducation());

			return mv;
		}

	}

	private String getPoiTagbyType(String id, String type) {
		if (Strings.isNullOrEmpty(type)) {
			return "";
		}

		Integer intType = Integer.parseInt(type);
		if (intType == 0) {
			LatestAttractions attraction = attractionDao.getAttractionById(id);
			List<BasePOILabel> basePOITags = attraction.getSubLabelNew();
			if (basePOITags != null && basePOITags.size() > 0) {
				return basePOITags.get(0).getLabel();
			}
		} else if (intType == 1) {
			Restaurants restaurant = restaurantDao.getRestaurantById(id);

			List<String> basePOITags = restaurant.getTagsZh();
			if (basePOITags != null && basePOITags.size() > 0) {
				return basePOITags.get(0);
			}
		} else if (intType == 2) {
			return "";
		} else if (intType == 3) {
			Areas area = areaDao.getAreaById(id);
			List<String> basePOITags = area.getTags();
			if (basePOITags != null && basePOITags.size() > 0) {
				return basePOITags.get(0);
			}
		}

		return "";
	}
}