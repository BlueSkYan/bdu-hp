package xyz.blueskyan.bduhpuser.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blueskyan.bduhpcommon.utils.R;

/**
 * @author Shijie Yan
 * @date 2023/2/10
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/doLogin")
    public R doLogin(String username, String password){
        if ("test".equals(username) && "123456".equals(password)){
            StpUtil.login(10001);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return R.success(tokenInfo);
        }
        return R.error("登录失败");
    }

    @RequestMapping("/isLogin")
    public String isLogin(){
        return "当前会话是否登录：" + StpUtil.isLogin() + StpUtil.getLoginId() + StpUtil.getTokenInfo();
    }
}
