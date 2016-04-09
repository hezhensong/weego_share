package share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.weego.main.dto.POIDetailCommentsDto;
import com.weego.main.model.BasePOITag;
import com.weego.main.util.HttpUtil;

public class HttpUtilTest extends BaseTest {
	
	@Test
	public void testPOI() {
	
		String url = "http://123.56.65.17/api/v2/pgcDetail";
		String pgcId = "56f64d76b6f958ff3c0000b6";
		JSONObject result =  JSONObject.parseObject(HttpUtil.sendGet(url, "pgcId=" + pgcId, "other"));
		JSONObject json = result.getJSONObject("result");
		List<Map<String, Object>> details = (List<Map<String, Object>>) json.get("pgc_poi");
		
		for(int i=0;i<details.size();i++) {
//			if(!"".equals(details.get(i).get("type"))) {
				if(details.get(i).get("detail") != null) {
					Map<String, Object> map = (Map<String, Object>) details.get(i).get("detail");
					System.out.println(map);
					if(map.size() == 0) {
						System.out.println(i + ":" + "为空map，但不是null");
						System.out.println(map.isEmpty());
					} else {
						System.out.println(i + "不为空");
						System.out.println(map.get("attractions"));
					}
				}
//			}
		}
		
		
	}
	
	
}
