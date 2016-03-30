import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weego.main.dao.ActivityDao;
import com.weego.main.dao.AreaDao;
import com.weego.main.dao.AttractionDao;
import com.weego.main.dao.PeopleDao;
import com.weego.main.dao.PgcDao;
import com.weego.main.dao.RestaurantDao;
import com.weego.main.dao.ShoppingDao;
import com.weego.main.model.LatestAttractions;
import com.weego.main.model.Shoppings;

public class ActivityDaoTest extends BaseTest {

	@Autowired
	ActivityDao activityDao;

	@Autowired
	AttractionDao attractionDao;

	@Autowired
	RestaurantDao restaurantDao;

	@Autowired
	ShoppingDao shoppingDao;

	@Autowired
	PgcDao pgcDao;

	@Autowired
	PeopleDao peopleDao;

	@Autowired
	AreaDao areaDao;

	/**
	 * 
	 */
	@Test
	public void test() {

		/*String activityId = "56d81f76e18046af1b00019b";
		System.out.println(activityDao.getSpecifiedCity(activityId));

		List<String> ids = attractionDao.getAllIds();
		for (String id : ids) {
			System.out.println(attractionDao.getAttractionById(id));
		}

		List<String> ids = restaurantDao.getAllIds();
		for (String id : ids) {
			System.out.println(restaurantDao.getRestaurantById(id));
		}

		List<String> ids = shoppingDao.getAllIds();
		for (String id : ids) {
			System.out.println(shoppingDao.getShoppingById(id));
		}

		List<String> ids = pgcDao.getAllIds();
		for (String id : ids) {
			System.out.println(pgcDao.getSpecifiedPgc(id));
		}

		List<String> ids = peopleDao.getAllIds();
		for (String id : ids) {
			System.out.println(peopleDao.getPeopleById(id));
		}*/

		
		
		 
//		 String attractionId = "516cc44ce3c6a60f69000006";
		 String shoppingId = "569a194c64f800f818000004";
		
		 Shoppings shoppings = shoppingDao.getShoppingById(shoppingId);
		if(shoppings.getOpenTime() instanceof List) {
			List<Map<String, String>> tempOpenTimes = (List<Map<String, String>>) shoppings.getOpenTime();
			System.out.println(tempOpenTimes.size());
		}
		 
		 
		/* Object openTimes = attraction.getOpenTime();
		 System.out.println(openTimes);
		 
		 List<String> openTimeDesc = new ArrayList<String>();
		 if(openTimes instanceof String) {
			 openTimeDesc.add((String) openTimes);
		 } else if(openTimes instanceof List) {
			 List<Map<String, String>> tempOpenTimes = (List<Map<String, String>>) openTimes;
			 if(tempOpenTimes != null && tempOpenTimes.size() > 0) {
				 for(Map<String, String> tempOpenTime:tempOpenTimes) {
					 openTimeDesc.add(tempOpenTime.get("desc"));
				 }
			 } 
		 }
		 System.out.println(openTimeDesc);*/

	}
}
