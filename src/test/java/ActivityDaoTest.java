import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weego.main.dao.ActivityDao;
import com.weego.main.dao.AreaDao;
import com.weego.main.dao.AttractionDao;
import com.weego.main.dao.PeopleDao;
import com.weego.main.dao.PgcDao;
import com.weego.main.dao.RestaurantDao;
import com.weego.main.dao.ShoppingDao;


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
//		String id = "56dfd21e99262f3856000001";
//		System.out.println(pgcDao.getSpecifiedPgc(id));
		
		String restaurantId = "5322c08d2fab6f0c1d000005";
		System.out.println(restaurantDao.getRestaurantById(restaurantId));
		
		String peopleId = "56e3dfb660f7fef169000246";
		System.out.println(peopleDao.getPeopleById(peopleId));
		
		String areaId = "53cdca4b8e33d8497e0000cf";
		System.out.println(areaDao.getAreaById(areaId));
	
	}
}
