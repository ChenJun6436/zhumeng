package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

/**
 * 
 * @className: DepartmentTest
 *
 * @description:部门单元测试
 *
 * @author wj
 *
 * @date 2017年10月25日下午7:23:49
 *
 */
public class DepartmentTest {
    
    /**
     * 根据类型ID获取部门列表数据
     */
//   @Test
     public void getDepartmentList() {

            Map params = new HashMap();
            params.put("typeId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");
            
            try {
                Http.post("sign/department/find_department_list", params);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

	/**
	 * 根据类型ID获取部门下拉数据
	 */
//	 @Test
	 public void getDepartment() {

			Map params = new HashMap();
//			params.put("typeId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");
			
			try {
				Http.post("sign/department/find_department", params);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 
	    /**
	     * 新增部门
	     */
	     @Test
	     public void addDepartment() {

	            Map params = new HashMap();
	            params.put("typeId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");
	            params.put("departmentName", "管理部门五");
//	            params.put("type", 1);
	            
	            try {
	                Http.post("sign/department/add_department", params);

	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }

	        }
	     
	     /**
	      * 修改部门信息
	      */
//	      @Test
	      public void updateDepartment() {

	             Map params = new HashMap();
 	             params.put("typeId", "d8a7e218-287d-4d2f-b137-b6c0efb49555");
 	             params.put("departmentId","2a05d1f4-b02a-4055-bffa-b677711c730c");
 	             params.put("departmentName","部门三");
 	            
	             try {
	                 Http.post("sign/department/update_department", params);

	             } catch (Exception e) {
	                 // TODO Auto-generated catch block
	                 e.printStackTrace();
	             }

	         }
	      
	      
	         /**
	          * 删除部门
	          */
//	        @Test
	          public void deleteDepartment() {

	                 Map params = new HashMap();
	                 params.put("departmentId","41032fe4-ddbe-41e9-8a71-8e9b7d65753");
	                
	                 try {
	                     Http.post("sign/department/delete_department", params);

	                 } catch (Exception e) {
	                     // TODO Auto-generated catch block
	                     e.printStackTrace();
	                 }

	             }
	      

}
