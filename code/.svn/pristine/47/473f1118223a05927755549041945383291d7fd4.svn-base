package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class EntryAreaTest {

	@Test
	public void findPage(){
		Map params = new HashMap();
//		params.put("cityId", "2638");
		params.put("townId", "1");
//		params.put("districtId", "2508");
		params.put("province", "2498");
		try {
			Http.post("entry_area/find_page", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void add(){
		Map params = new HashMap();
		params.put("town", "高明镇");
		params.put("village", "海乐村");
		params.put("districtId", "2644");
//		params.put("parent", "5");
		
//		params.put("townId", "1");
		try {
			Http.post("entry_area/add", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void update(){
		Map params = new HashMap();
		params.put("townName", "测试乡镇");
		params.put("townId", "5");
		params.put("villageId", "6");
		params.put("villageName", "测试村");
		try {
			Http.post("entry_area/update", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void updatestatus(){
		Map params = new HashMap();
		params.put("village_id", "3");
		try {
			Http.post("entry_area/update_status", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void findTownOption(){
		Map params = new HashMap();
		params.put("district_id", "2645");
		try {
			Http.post("entry_area/find_town_option", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findVillageOption(){
		Map params = new HashMap();
		params.put("town_id", "1");
		try {
			Http.post("entry_area/find_village_option", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
