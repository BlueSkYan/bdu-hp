package xyz.blueskyan.bduhpuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.bduhpuser.vo.UserInfoAllVo;
import xyz.blueskyan.bduhpuser.vo.UserInfoVo;
import xyz.blueskyan.bduhpuser.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-27
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 根据用户id查找用户信息
     * @param userId 用户id
     * @return UserInfoVo
     */
    UserInfoVo getInfoByUserId(String userId);

    /**
     * 上传文件
     * @param file 文件
     * @param userId 用户id
     */
    void upload(MultipartFile file, String userId);

    /**
     * 查询用户列表
     * @return List<UserInfoAllVo>
     */
    List<UserInfoAllVo> listUsers();

    /**
     * 设置赏金
     * @param id id
     * @param userId 用户id
     */
    void setReward(int id, int userId);
}
