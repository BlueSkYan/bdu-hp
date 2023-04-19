package xyz.blueskyan.bduhpadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.blueskyan.bduhpadmin.feign.UserFeignService;
import xyz.blueskyan.bduhpadmin.feign.XuqiuFeignService;
import xyz.blueskyan.bduhpcommon.utils.R;

import java.util.Map;

/**
 * @author Shijie Yan
 * @date 2023/3/3
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private XuqiuFeignService xuqiuFeignService;

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/list")
    public R list(){
        return xuqiuFeignService.list();
    }

    @GetMapping("/delete")
    public R delete(Integer id){
        return xuqiuFeignService.delete(id);
    }

    @GetMapping("/approve")
    public R approve(Integer id){
        return xuqiuFeignService.approve(id);
    }

    @GetMapping("/notApprove")
    public R notApprove(Integer id){
        return xuqiuFeignService.notApprove(id);
    }

    @GetMapping("/getUsersList")
    public R listUsers(){
        return userFeignService.listUsers();
    }

    @GetMapping("/deleteUser")
    public R deleteUser(Integer id){
        return userFeignService.userDelete(id);
    }

    @PostMapping("/edit")
    public R edit(@RequestBody Map<String, Object> map){
        return userFeignService.edit((Integer) map.get("id"), (String) map.get("phoneNumber"));
    }

    @GetMapping("/ban")
    public R ban(Integer id){
        return userFeignService.ban(id);
    }

    @GetMapping("/noBan")
    public R noBan(Integer id){
        return userFeignService.noBan(id);
    }

    @GetMapping("/listSorts")
    public R listSorts(){
        return xuqiuFeignService.listSorts();
    }

    @PostMapping("/addSort")
    public R addSort(@RequestParam("sort") String sort){
        return xuqiuFeignService.addSort(sort);
    }

    @GetMapping("/delSort")
    public R delSort(Integer id){
        return xuqiuFeignService.delSort(id);
    }
}
