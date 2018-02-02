package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;


/**
 * 用户角色类型单元测试
 * @className: TypeTest
 *
 * @description:
 *
 * @author wj
 *
 * @date 2017年10月25日下午6:50:21
 *
 */
public class TypeTest {
    
    /**
     * 获取视频唯一标识
     */
//     @Test
     public void getSysCode() {

            Map params = new HashMap();
            params.put("pageNo", 1);
            params.put("pageSize", 15);
//            params.put("updateTime", 0);
//            params.put("fetchType", 0);
            params.put("appkey", "9877c543");
            
            try {
                Http.post("/webapi/service/vss/getPlatCameraResListByCameraName", params);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

	/**
	 * 获取所有角色类型
	 */
	 @Test
	 public void getType() {

			Map params = new HashMap();
			
			try {
				Http.post("sign/type/find_all", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 
	    /**
	     * 新增角色类型
	     */
//	     @Test
	     public void addType() {

	            Map params = new HashMap();
	            params.put("typeName", "后台管理员");
	            
	            try {
	                Http.post("sign/type/add_type", params);

	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }

	        }
	     
	     /**
	      * 修改类型名称
	      */
//	      @Test
	      public void updateType() {

	             Map params = new HashMap();
 	             params.put("typeId", "d8a7e218-287d-4d2f-b137-b6c0efb49555");
 	             params.put("typeName","监控机构");
	             
	             try {
	                 Http.post("/sign/type/update_type", params);

	             } catch (Exception e) {
	                 // TODO Auto-generated catch block
	                 e.printStackTrace();
	             }

	         }
	      

}
