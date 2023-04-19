package xyz.blueskyan.bduhpuser.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.entity.User;
import xyz.blueskyan.bduhpuser.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Shijie Yan
 * @date 2023-02-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public R login(@RequestBody User user){
        return userService.doLogin(user);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public R register(@RequestBody User user){
        if (userService.doRegister(user.getUsername(), user.getPassword(), user.getPhoneNumber())){
            return R.success("注册成功");
        }
        return R.error("账号已存在");
    }

    /**
     * 登出
     */
    @RequestMapping("logout")
    public void logout(){
        StpUtil.logout();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/del")
    public R del(Integer id){
        userService.removeById(id);
        return R.success();
    }

    @GetMapping("/getPhoneNum")
    public R getPhoneNum(Integer userId){
        String phone = userService.getPhone(userId);
        return R.success(phone);
    }
}
