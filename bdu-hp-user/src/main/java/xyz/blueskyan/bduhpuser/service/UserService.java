package xyz.blueskyan.bduhpuser.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.entity.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-10
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param user 用户Entity
     * @return SaTokenInfo
     */
    R doLogin(User user);

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param phoneNumber 手机号
     * @return b
     */
    boolean doRegister(String username, String password, String phoneNumber);

    /**
     * 获取手机号
     * @param userId 用户ID
     * @return String
     */
    String getPhone(Integer userId);

    /**
     * 修改手机号
     * @param id 用户id
     * @param phoneNumber 手机号
     */
    void updatePhoneNum(Integer id, String phoneNumber);

    /**
     * 禁用
     * @param id
     */
    void ban(Integer id);

    /**
     * 取消禁用
     * @param id
     */
    void noBan(Integer id);
}
