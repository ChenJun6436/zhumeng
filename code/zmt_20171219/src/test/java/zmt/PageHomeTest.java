package zmt;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import util.Http;

public class PageHomeTest {

	@Test
	public void getTodayReal(){
		Map params = new HashMap();
		params.put("id", "2645");
		params.put("type", "3");
		try {
			Http.post("home/page/real_count", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getPicValue(){
		Map params = new HashMap();
		params.put("id", "2498");
		params.put("type", "2");
		try {
			Http.post("home/page/get_pic_value", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findPage(){
		Map params = new HashMap();
		params.put("pig_id", "55555555");
		params.put("start", "2");
		params.put("length", "10");
		try {
			Http.post("home/page/find_by_id", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAddress(){
		Map params = new HashMap();
		try {
			Http.post("account/manage/verify_by_id1", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
