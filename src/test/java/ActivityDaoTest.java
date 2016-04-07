import java.util.List;

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

		System.out.println("start testing");
		
		/*List<String> ids = attractionDao.getAllIds();
		for (String id : ids) {
			System.out.println(attractionDao.getAttractionById(id));
		}*/

		/*List<String> ids = restaurantDao.getAllIds();
		for (String id : ids) {
			System.out.println(restaurantDao.getRestaurantById(id));
		}*/

		/*List<String> ids = shoppingDao.getAllIds();
		for (String id : ids) {
			System.out.println(shoppingDao.getShoppingById(id));
		}*/

		String id = "56ab050dcc15499619000251";
		System.out.println(pgcDao.getSpecifiedPgc(id));
		
		/*	List<String> ids = pgcDao.getAllIds();
		for (String id : ids) {
			System.out.println(id);
			System.out.println(pgcDao.getSpecifiedPgc(id));
		}*/

		/*List<String> ids = peopleDao.getAllIds();
		for (String id : ids) {
			System.out.println(peopleDao.getPeopleById(id));
		}*/

	}
}
