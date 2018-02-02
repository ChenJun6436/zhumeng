package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;

/**
 * 
 * @className: UserbaseTest
 *
 * @description:用户基础类单元测试
 *
 * @author wj
 *
 * @date 2017年11月9日下午1:51:29
 *
 */
public class UserbaseTest {
    
    /**
     * 发送验证码
     */
    @Test
    public void sendVerifyCode() {

        Map params = new HashMap();
        params.put("tel","18384235850");

        try {
            Http.post("/sign/userbase/sendVerifyCode", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 校验验证码
     */
    @Test
    public void verifyCheckCode() {

        Map params = new HashMap();
        params.put("tel","18384235850");
        params.put("checkCode","264846");

        try {
            Http.post("/sign/userbase/verifyCheckCode", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 获取用户类型部门角色信息
     */
//    @Test
    public void getUserInfo() {

        Map params = new HashMap();
        params.put("userId","2fabb58893234b6fb3627ca391632eb0");

        try {
            Http.post("/sign/userbase/getUserInfo", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 用户登录
     */
 //   @Test
    public void loginUser() {

        Map params = new HashMap();
        params.put("account", "JD64445703");
        params.put("password","c52d9d3e8337de6889824b41b10a7a15");
        params.put("code","12345");

        try {
            Http.post("/sign/userbase/login", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    /**
     * 重置密码
     */
//    @Test
    public void updatePassword() {

        Map params = new HashMap();
        params.put("account", "4234232");
        params.put("password","ZMT123456");
        params.put("newPassword","123456789");

        try {
            Http.post("sign/userbase/updatePassword", params);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    

}
