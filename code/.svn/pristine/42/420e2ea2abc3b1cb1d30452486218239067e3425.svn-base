package zmt;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import util.Http;


/**
 * 
 * @className: HikVideoTest
 *
 * @description:视频地址信息单元测试
 *
 * @author wj
 *
 * @date 2017年12月14日下午3:58:28
 *
 */
public class HikVideoTest {
    
    /**
     * 获取视频标识
     */
     @Test
     public void getVideo() {

            Map params = new HashMap();
            params.put("slaughterhouseId", "b76e39c102a54e408cb5c6d92d91070e");
            
            try {
                Http.post("/sign/video/find_video", params);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
     
     /**
      * 删除视频标识
      */
      @Test
      public void deleteVideo() {

             Map params = new HashMap();
             params.put("slaughterhouseId", "b76e39c102a54e408cb5c6d92d91070e");
             
             try {
                 Http.post("/sign/video/delete_video", params);

             } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }

         }

}
