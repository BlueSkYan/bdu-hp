package xyz.blueskyan.bduhpadmin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.blueskyan.bduhpcommon.utils.R;

/**
 * @author Shijie Yan
 * @date 2023/3/4
 */
@FeignClient(name = "UserFeign" , url = "http://localhost:10000/forAdmin")
public interface UserFeignService {

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/userInfo/getUsersInfo")
    R listUsers();

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/user/del")
    R userDelete(@RequestParam("id") Integer id);

    /**
     * 修改手机号
     * @param id
     * @param phoneNumber
     * @return
     */
    @PostMapping("/user/edit")
    R edit(@RequestParam("id") Integer id, @RequestParam("phoneNumber") String phoneNumber);

    /**
     * 账号禁用
     * @param id
     * @return
     */
    @GetMapping("/user/ban")
    R ban(@RequestParam("id") Integer id);

    /**
     * 解除封禁
     * @param id
     * @return
     */
    @GetMapping("/user/noBan")
    R noBan(@RequestParam("id") Integer id);
}
