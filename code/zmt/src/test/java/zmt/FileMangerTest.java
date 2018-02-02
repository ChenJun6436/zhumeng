package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class FileMangerTest {

	@Test
	public void findBulider() {

		Map params = new HashMap();

		// params.put("departmentId", "7ee5c86f-44d0-44cf-ad07-4c003f5976de");

		try {
			Http.post("manger/fileManger", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void getPigBreed() {

		Map params = new HashMap();

		try {
			Http.post("/pig_breed/getByEnable", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void findRoleByResurce() {

		Map params = new HashMap();

		try {

			Http.post("manger/role/byResource", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void findDepartmentByResurce() {

		Map params = new HashMap();

		try {

			Http.post("manger/department/byResource", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void forbidOrstart() {

		Map params = new HashMap();

		params.put("userId", "1");
		params.put("status", "disable");
		try {
			Http.post("manger/forbidOrStart/byStatus", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void findFileByBulidId() {

		Map params = new HashMap();

		params.put("userId", "41fba35991764fa7ac2d09bc16bfe980");
		/* params.put("sign", "123456788"); */

		try {
			Http.post("manger/findFile/bybuildId", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void findFileBySign() {

		Map params = new HashMap();

		params.put("userId", "1");
		params.put("sign", "1");

		try {
			Http.post("manger/findFile/bySign", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void saveFile() {

		Map params = new HashMap();

		params.put("sign", "2134344");
		params.put("famerId", "425234");
		params.put("pigType", "1234");
		params.put("createPeopleId", "1");
		params.put("mark", "1343525");

		try {
			Http.post("file/createFile", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void activeSign() {

		Map params = new HashMap();

		params.put("sign", "333333333");
		params.put("userId", "1");

		try {
			Http.post("manger/activeSign/byStatus", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void deleteSign() {

		Map params = new HashMap();

		params.put("sign", "123456789");

		try {
			Http.post("manger/deleteSign/byStatus", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
