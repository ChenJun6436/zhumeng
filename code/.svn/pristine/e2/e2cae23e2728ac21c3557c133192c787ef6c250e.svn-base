package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

/**
 * @className: RoleTest
 * @description:角色单元测试
 * @author wj
 * @date 2017年10月30日下午5:16:02
 */
public class RoleTest {
    
    /**
     * 获取角色列表数据
     */
    @Test
    public void getRoleList() {

        Map params = new HashMap();
        params.put("typeId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");
        params.put("start",0);
        params.put("length",10);
 //     params.put("departmentId", "7ee5c86f-44d0-44cf-ad07-4c003f5976de");
 //     params.put("roleId", "7ee5c86f-44d0-44cf-ad07-4c003f5976de");

        try {
            Http.post("/sign/role/find_role_list", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 获取角色下拉数据
     */
//    @Test
    public void getRole() {

        Map params = new HashMap();
 //       params.put("departmentId", "7ee5c86f-44d0-44cf-ad07-4c003f5976de");

        try {
            Http.post("sign/role/find_role", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 新增角色
     */
//    @Test
    public void addRole() {

        Map params = new HashMap();
        params.put("roleName", "检疫人员1");
        params.put("departmentId", "7ee5c86f-44d0-44cf-ad07-4c003f5976de");
        params.put("typeId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");
        params.put("resourceIds", "[{resourceId:'4ab39273-5c1b-4fd0-8f95-8126a1611f02',type:'0'},{resourceId:'30727ca9-e1c6-4fb1-8c3a-d3425bb44464',type:'1'}]");

        try {
            Http.post("sign/role/add_role", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 修改角色信息
     */
//     @Test
    public void updateRole() {

        Map<String, Object> params = new HashMap();
        params.put("roleName", "来自小可爱1的测试");
        params.put("departmentId", "0395e592-cb1b-4474-9f25-3767427a0a32");
        params.put("roleId", "2eb8a2c1-8610-43f0-b1b2-3fbc0eda4a72");
        params.put("resourceIds", "[{resourceId:'4ab39273-5c1b-4fd0-8f95-8126a1611f02',type:'0'},{resourceId:'30727ca9-e1c6-4fb1-8c3a-d3425bb44464',type:'1'}]");


        try {
            Http.post("sign/role/update_role", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


   

    /**
     * 删除角色
     */
//    @Test
    public void deleteRole() {

        Map params = new HashMap();
        params.put("roleId", "d6038cb6-5822-49f0-b96e-4510a1e758ec");

        try {
            Http.post("sign/role/delete_role", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
