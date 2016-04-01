package com.weego.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weego.main.service.ActivityService;
import com.weego.main.service.BasePOIService;
import com.weego.main.service.PgcService;

@Controller
@RequestMapping("/app")
public class ShareController {
	
	@Autowired
	PgcService pgcService;
	
	@Autowired
	ActivityService activityService;
    
    @Autowired
    BasePOIService basePOIService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getShare() {

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "Weego");

        return mv;
    }
    
    @RequestMapping(value = "/pgc/{pgcId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getPgc(@PathVariable("pgcId") String pgcId) {

        return pgcService.getSpecifiedPgc(pgcId);
    }
    
    @RequestMapping(value = "/activity/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getActivity(@PathVariable("activityId") String activityId) {

        return activityService.getSpecifiedActivity(activityId);
    }
    
    @RequestMapping(value = "/{type}/poi/{poiId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getPOI(@PathVariable("type") Integer type,
    		@PathVariable("poiId") String poiId) {

        return basePOIService.getPOIDetail(poiId, type);
    }

}
