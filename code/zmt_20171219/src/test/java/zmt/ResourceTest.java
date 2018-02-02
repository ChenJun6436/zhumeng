package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

/**
 * 
 * @className: ResourceTest
 *
 * @description:
 *
 * @author wj
 *
 * @date 2017年10月31日下午4:09:38
 *
 */
public class ResourceTest {


    /**
     * 获取资源数据
     */
//    @Test
    public void getResource() {

        Map params = new HashMap();
 //       params.put("departmentId", "4ab39273-5c1b-4fd0-8f95-8126a1611f02");

        try {
            Http.post("/sign/resource/find_resource", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 根据角色ID获取资源数据
     */
    @Test
    public void getRoleResource() {

        Map params = new HashMap();
        params.put("roleId", "a52c1e9e-4c6e-4d7e-ab31-ca1e715ef62f");

        try {
            Http.post("/sign/resource/find_role_resource", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
