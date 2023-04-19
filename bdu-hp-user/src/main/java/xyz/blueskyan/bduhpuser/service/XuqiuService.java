package xyz.blueskyan.bduhpuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.blueskyan.bduhpuser.entity.Xuqiu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-14
 */
public interface XuqiuService extends IService<Xuqiu> {

    /**
     * 根据状态查询需求
     * @return List<Xuqiu>
     */
    List<Xuqiu> listByStatus();

    /**
     * 根据userId查询
     * @param userId 用户id
     * @return List<Xuqiu>
     */
    List<Xuqiu> listByUserId(String userId);

    /**
     * 根据解决人id查询
     * @param userId 用户id
     * @return List<Xuqiu>
     */
    List<Xuqiu> listBySolverId(String userId);

    /**
     * 去帮忙
     * @param id id
     * @param userId 用户id
     */
    void goToHelp(int id, int userId);

    /**
     * 查询输出反转顺序
     * @return List<Xuqiu>
     */
    List<Xuqiu> listByDesc();

    /**
     * 根据id通过
     * @param id id
     */
    void approveById(Integer id);

    /**
     * 不通过根据id
     * @param id id
     */
    void notApproveById(Integer id);
}
