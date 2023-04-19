package xyz.blueskyan.bduhpuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.entity.UserInfo;
import xyz.blueskyan.bduhpuser.service.UserInfoService;
import xyz.blueskyan.bduhpuser.vo.UserInfoVo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-27
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId){
        System.out.println(userId);
        userInfoService.upload(file, userId);
        return R.success();
    }

    @RequestMapping("/getUserInfo")
    public R getUserInfo(String userId){
        UserInfoVo userInfoVo = userInfoService.getInfoByUserId(userId);
        return R.success(userInfoVo);
    }
}
