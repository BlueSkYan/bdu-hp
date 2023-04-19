package xyz.blueskyan.bduhpuser.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.blueskyan.bduhpcommon.utils.R;
import xyz.blueskyan.bduhpuser.entity.User;
import xyz.blueskyan.bduhpuser.mapper.UserMapper;
import xyz.blueskyan.bduhpuser.service.UserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 登录服务
     * @param user
     * @return
     */
    @Override
    public R doLogin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User one = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (one != null){
            if(one.getBanned()){
                return R.error("账号被封禁!");
            }else {
                if (encoder.matches(user.getPassword(), one.getPassword())) {
                    StpUtil.login(one.getId());
                    return R.success(StpUtil.getTokenInfo());
                }else {
                    return R.error("密码错误!");
                }
            }
        }
        return R.error("账号不存在！");
    }

    /**
     * 注册服务
     * @param username
     * @param password
     * @return b
     */
    @Override
    public boolean doRegister(String username, String password, String phoneNumber) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User one = this.getOne(new QueryWrapper<User>().eq("username", username));
        if (one == null){
            String enPassword = encoder.encode(password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(enPassword);
            user.setPhoneNumber(phoneNumber);
            this.save(user);
            return true;
        }
        return false;
    }

    @Override
    public String getPhone(Integer userId) {
        User user = this.getById(userId);
        return user.getPhoneNumber();
    }

    @Override
    public void updatePhoneNum(Integer id, String phoneNumber) {
        User user = new User();
        user.setId(id);
        user.setPhoneNumber(phoneNumber);
        this.updateById(user);
    }

    @Override
    public void ban(Integer id) {
        User user = new User();
        user.setId(id);
        user.setBanned(true);
        this.updateById(user);
    }

    @Override
    public void noBan(Integer id) {
        User user = new User();
        user.setId(id);
        user.setBanned(false);
        this.updateById(user);
    }


}
