package xyz.blueskyan.bduhpuser.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.service.UserInfoService;
import xyz.blueskyan.bduhpuser.service.UserService;
import xyz.blueskyan.bduhpuser.service.XuqiuService;
import xyz.blueskyan.bduhpuser.service.XuqiuTypeService;

/**
 * @author Shijie Yan
 * @date 2023/3/13
 */
@RestController
@RequestMapping("/forAdmin")
public class ForAdminController {

    @Autowired
    private XuqiuService xuqiuService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private XuqiuTypeService xuqiuTypeService;

    @GetMapping("/xuqiu/listAll")
    public R listAll(){
        return R.success(xuqiuService.listByDesc());
    }

    @GetMapping("/xuqiu/toDel")
    public R toDel(Integer id){
        xuqiuService.removeById(id);
        return R.success();
    }

    @GetMapping("/xuqiu/toApprove")
    public R toApprove(Integer id){
        xuqiuService.approveById(id);
        return R.success();
    }

    @GetMapping("/xuqiu/toNotApprove")
    public R toNotApprove(Integer id){
        xuqiuService.notApproveById(id);
        return R.success();
    }

    @GetMapping("/userInfo/getUsersInfo")
    public R getUsers(){
        return R.success(userInfoService.listUsers());
    }

    @GetMapping("/user/del")
    public R del(Integer id){
        userService.removeById(id);
        return R.success();
    }

    @PostMapping("/user/edit")
    public R edit(Integer id, String phoneNumber){
        userService.updatePhoneNum(id, phoneNumber);
        return R.success("修改成功");
    }

    @GetMapping("/user/ban")
    public R ban(Integer id){
        userService.ban(id);
        return R.success("禁用成功");
    }

    @GetMapping("/user/noBan")
    public R noBan(Integer id){
        userService.noBan(id);
        return R.success("取消禁用成功");
    }

    @GetMapping("/xuqiuType/list")
    public R listSorts(){
        return R.success(xuqiuTypeService.list());
    }

    @PostMapping("/xuqiuType/add")
    public R addSort(String sort){
        xuqiuTypeService.add(sort);
        return R.success("增加成功");
    }

    @GetMapping("/xuqiuType/del")
    public R delSort(Integer id){
        xuqiuTypeService.removeById(id);
        return R.success("删除成功");
    }
}
