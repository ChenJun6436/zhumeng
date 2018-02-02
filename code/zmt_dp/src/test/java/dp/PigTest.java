package dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class PigTest {

	/**
	 * 获取所有角色类型
	 */
	@Test
	public void getPigType() {

		Map params = new HashMap();
		// params.put("lawyerId", 1);

		try {
			Http.post("pig/getPigType", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有角色类型
	 */
	@Test
	public void getOverview() {

		Map params = new HashMap();
		// params.put("lawyerId", 1);

		try {
			Http.post("pig/getOverview", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取生猪TOP5
	 */
	@Test
	public void getPigTop5() {

		Map params = new HashMap();
		// params.put("lawyerId", 1);

		try {
			Http.post("pig/getPigTop5", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
