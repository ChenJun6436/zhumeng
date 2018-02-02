package dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;



public class UserTest {

	/**
	 * 用户登录
	 */
	 @Test
	 public void userLogin() {

			Map params = new HashMap();
			params.put("account", "zizhong");
			params.put("password", "ZMT123456");
			
			try {
				Http.post("user/login", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 
	    /**
		 * 获取
		 */
		 @Test
		 public void getArea() {

				Map params = new HashMap();
				
				try {
					Http.post("user/getArea", params);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	 

}
