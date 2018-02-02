package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class PigBreedTest {

	@Test
	public void add(){
		Map params = new HashMap();
		params.put("name", "测试1");
		try {
			Http.post("pig_breed/add", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAll(){
		Map params = new HashMap();
		try {
			Http.post("pig_breed/find_all", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete(){
		Map params = new HashMap();
		params.put("id", "a87f7c4a-5f8b-4ae2-bac7-3f71ea27289d");
		try {
			Http.post("pig_breed/update_status", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
