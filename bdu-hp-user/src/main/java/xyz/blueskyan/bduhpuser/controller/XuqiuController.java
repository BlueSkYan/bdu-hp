package xyz.blueskyan.bduhpuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.entity.Xuqiu;
import xyz.blueskyan.bduhpuser.service.UserInfoService;
import xyz.blueskyan.bduhpuser.service.XuqiuService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-14
 */
@RestController
@RequestMapping("/xuqiu")
public class XuqiuController {

    @Autowired
    private XuqiuService xuqiuService;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/save")
    public R save(@RequestBody Xuqiu xuqiu){
        xuqiuService.save(xuqiu);
        return R.success("发布成功");
    }

    @GetMapping("/list")
    public R list(){
        return R.success(xuqiuService.listByStatus());
    }

    @GetMapping("/getMySaved")
    public R getMySaved(String userId){
        return R.success(xuqiuService.listByUserId(userId));
    }

    @GetMapping("/getMySolved")
    public R getMySolved(String userId){
        return R.success(xuqiuService.listBySolverId(userId));
    }

    @GetMapping("/goHelp")
    public R goHelp(int id, int userId){
        xuqiuService.goToHelp(id, userId);
        userInfoService.setReward(id, userId);
        return R.success();
    }

    @GetMapping("/toDel")
    public R toDel(Integer id){
        xuqiuService.removeById(id);
        return R.success();
    }

    @PostMapping("/update")
    public R update(@RequestBody Xuqiu xuqiu){
        xuqiuService.updateById(xuqiu);
        return R.success();
    }
}
