package xyz.blueskyan.bduhpadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blueskyan.bduhpadmin.feign.XuqiuFeignService;
import xyz.blueskyan.bduhpcommon.utils.R;

/**
 * @author Shijie Yan
 * @date 2023/3/3
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private XuqiuFeignService userFeignService;

    @GetMapping("/list")
    public R list(){
        return userFeignService.list();
    }
}
