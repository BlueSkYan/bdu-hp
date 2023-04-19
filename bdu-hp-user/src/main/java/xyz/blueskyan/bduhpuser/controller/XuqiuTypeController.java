package xyz.blueskyan.bduhpuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.service.XuqiuTypeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-04-11
 */
@RestController
@RequestMapping("/xuqiuType")
public class XuqiuTypeController {

    @Autowired
    private XuqiuTypeService xuqiuTypeService;

    @GetMapping("/list")
    public R list(){
        return R.success(xuqiuTypeService.list());
    }
}
