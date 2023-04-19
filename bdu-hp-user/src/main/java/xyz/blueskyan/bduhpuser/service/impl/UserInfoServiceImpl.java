package xyz.blueskyan.bduhpuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.blueskyan.bduhpuser.entity.Xuqiu;
import xyz.blueskyan.bduhpuser.service.XuqiuService;
import xyz.blueskyan.bduhpuser.vo.UserInfoAllVo;
import xyz.blueskyan.bduhpuser.vo.UserInfoVo;
import xyz.blueskyan.bduhpuser.entity.User;
import xyz.blueskyan.bduhpuser.entity.UserInfo;
import xyz.blueskyan.bduhpuser.mapper.UserInfoMapper;
import xyz.blueskyan.bduhpuser.service.UserInfoService;
import xyz.blueskyan.bduhpuser.service.UserService;
import xyz.blueskyan.bduhpuser.utils.MinioUtil;
import xyz.blueskyan.bduhpuser.utils.NameUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserService userService;

    @Autowired
    private XuqiuService xuqiuService;

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private NameUtil nameUtil;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.endpoint}")
    private String endPoint;

    @Override
    public UserInfoVo getInfoByUserId(String userId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        UserInfo userInfo = this.getOne(wrapper);
        if (userInfo != null) {
            User user = userService.getById(userInfo.getUserId());
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUsername(user.getUsername());
            BeanUtils.copyProperties(userInfo, userInfoVo);
            return userInfoVo;
        }
        return null;
    }

    @Override
    public void upload(MultipartFile file, String userId) {
        String nanoId = nameUtil.getNanoId(file.getOriginalFilename());
        String str = endPoint + "/" + bucketName + "/" + nanoId;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserImage(str);
        userInfo.setUserId(Integer.parseInt(userId));
        this.saveOrUpdate(userInfo, new UpdateWrapper<UserInfo>().eq("user_id", userId));
        minioUtil.upload(bucketName, nanoId, file);
    }

    @Override
    public List<UserInfoAllVo> listUsers() {
        List<User> userList = userService.list();
        List<UserInfoAllVo> collect = userList.stream().map(item -> {
            UserInfoAllVo userInfoAllVo = new UserInfoAllVo();
            UserInfo userInfo = this.getOne(new QueryWrapper<UserInfo>().eq("user_id", item.getId()));
            userInfoAllVo.setId(item.getId());
            userInfoAllVo.setUsername(item.getUsername());
            userInfoAllVo.setPhoneNumber(item.getPhoneNumber());
            userInfoAllVo.setCreateTime(item.getCreateTime());
            userInfoAllVo.setBanned(item.getBanned());
            userInfoAllVo.setUserImage(userInfo.getUserImage());
            userInfoAllVo.setReward(userInfo.getReward());
            return userInfoAllVo;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void setReward(int id, int userId) {
        Xuqiu xuqiu = xuqiuService.getById(id);
        UserInfo one = this.getOne(new QueryWrapper<UserInfo>().eq("user_id", userId));
        BigDecimal money = xuqiu.getPrice().add(one.getReward());
        UserInfo userInfo = new UserInfo();
        userInfo.setReward(money);
        this.update(userInfo, new UpdateWrapper<UserInfo>().eq("user_id", userId));
    }
}
