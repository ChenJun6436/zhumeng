package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class AreaTest {

	@Test
	public void findProvince(){
		Map params = new HashMap();
		params.put("cityId", "2638");
		try {
			Http.post("area/find_province_option", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findCity(){
		Map params = new HashMap();
		params.put("province_id", "2");
		try {
			Http.post("area/find_city_option", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findDistrict(){
		Map params = new HashMap();
		params.put("city_id", "2499");
		try {
			Http.post("area/find_district_option", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findZtree(){
		Map params = new HashMap();
		params.put("id", "2498");
		params.put("type", "1");
		try {
			Http.post("area/find_ztree", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
