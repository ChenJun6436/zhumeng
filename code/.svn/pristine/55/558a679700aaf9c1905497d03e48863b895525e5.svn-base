package dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

public class SlaughterTest {
	@Test
	 public void countPigAndSlaughterForYear() {
			Map params = new HashMap();
//			params.put("lawyerId", 1);
			try {
				Http.post("find/pig_and_slaughter_for_year", params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	@Test
	 public void findSlaughtTop5() {
		Map params = new HashMap();
		try {
			Http.post("find/slaughter/top5", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
