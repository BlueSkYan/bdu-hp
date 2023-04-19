package xyz.blueskyan.bduhpadmin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.blueskyan.bduhpcommon.utils.R;

/**
 * @author Shijie Yan
 * @date 2023/3/3
 */
@FeignClient(name = "XuqiuFeign" , url = "http://localhost:10000/forAdmin")
public interface XuqiuFeignService {

    /**
     * 获取需求列表
     * @return R
     */
    @GetMapping("/xuqiu/listAll")
    R list();

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @GetMapping("/xuqiu/toDel")
    R delete(@RequestParam("id") Integer id);

    /**
     * 发送通过请求
     * @param id
     * @return
     */
    @GetMapping("/xuqiu/toApprove")
    R approve(@RequestParam("id") Integer id);

    /**
     * 发送不通过请求
     * @param id
     * @return
     */
    @GetMapping("/xuqiu/toNotApprove")
    R notApprove(@RequestParam("id") Integer id);

    /**
     * 查询所有类型
     * @return
     */
    @GetMapping("/xuqiuType/list")
    R listSorts();

    /**
     * 增加类型
     * @param sort
     * @return
     */
    @PostMapping("/xuqiuType/add")
    R addSort(@RequestParam("sort") String sort);

    /**
     * 删除类型
     * @param id
     * @return
     */
    @GetMapping("/xuqiuType/del")
    R delSort(@RequestParam("id") Integer id);
}
