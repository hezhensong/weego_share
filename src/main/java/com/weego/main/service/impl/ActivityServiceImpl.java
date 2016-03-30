package com.weego.main.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.weego.main.dao.ActivityDao;
import com.weego.main.model.Activities;
import com.weego.main.service.ActivityService;

@Service("cityActivityService")
public class ActivityServiceImpl implements ActivityService {

	private Logger logger = LogManager.getLogger(ActivityServiceImpl.class);
	private String imageUrl = "http://weegotest.b0.upaiyun.com/activities/iosimgs/";
	
	@Autowired
	private ActivityDao cityActivityDao;

	@Override
	public ModelAndView getSpecifiedActivity(String activityId) {

		ModelAndView mv = new ModelAndView("activity");
		
		try {
			Activities activity = cityActivityDao.getSpecifiedCity(activityId);
			if (activity != null) {
				mv.addObject("title", activity.getTitle());
				mv.addObject("time", activity.getActTime());
				mv.addObject("tag", activity.getType());
				mv.addObject("ip", activity.getDetailAddress());
				mv.addObject("bg", imageUrl + activity.getCoverImage());
				mv.addObject("web", activity.getActUrl());
				mv.addObject("ticket", activity.getOrderUrl());
				mv.addObject("details", activity.getDesc());
				mv.addObject("paragraphs", "");
			}
		} catch (Exception e) {
			logger.info("活动接口出错!");
			e.printStackTrace();
		}

		return mv;
	}
}
