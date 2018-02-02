package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jf.projects.zmt.vo.account.UserAreaVo;

import util.Http;

public class AccountTest {
	@Test
	public void findProvince(){
		Map params = new HashMap();
//		params.put("keywords", "zhangsan");
		try {
			Http.post("account/manage/find_page", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void findAccountInfoByUserId(){
		Map params = new HashMap();
		params.put("user_id", "1");
		try {
			Http.post("account/manage/find_info_by_id", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void findUserArea(){
		Map params = new HashMap();
		params.put("user_id", "1");
		try {
			Http.post("account/manage/find_area_by_user", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void add(){
		Map params = new HashMap();
		params.put("typeId", "1");
		params.put("departmentId", "1");
		params.put("roleId", "1");
		params.put("loginName", "test");
		params.put("password", "123456");
		params.put("name", "测试账号1");
		params.put("tel", "18384235850");
		params.put("villageId", "1");
//		params.put("areaList", "{areaId:2499,areaName:'成都市',type:2}");
		//params.put("areaList", "[{areaId:2499,areaName:'成都市',type:2},{areaId:2520,areaName:'自贡市',type:2}]");
		
		try {
			Http.post("account/manage/add", params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Test
		public void updateStatus(){
			Map params = new HashMap();
			params.put("user_id", "160b9b6e-fb71-4143-b366-b135d00d041e");
			try {
				Http.post("account/manage/update_status", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void update(){
			Map params = new HashMap();
			params.put("userId", "160b9b6e-fb71-4143-b366-b135d00d041e");
			params.put("loginName", "test1");
			params.put("name", "测试账号11");
			try {
				Http.post("account/manage/update", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void restPwd(){
			Map params = new HashMap();
			params.put("user_id", "160b9b6e-fb71-4143-b366-b135d00d041e");
			try {
				Http.post("account/manage/rest_pwd", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void delete(){
			Map params = new HashMap();
			params.put("user_id", "f819d448-a52b-4e3c-b090-8b4201b55395");
			try {
				Http.post("account/manage/delete", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
}
