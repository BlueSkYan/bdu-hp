package xyz.blueskyan.bduhpuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.blueskyan.bduhpuser.entity.XuqiuType;
import xyz.blueskyan.bduhpuser.mapper.XuqiuTypeMapper;
import xyz.blueskyan.bduhpuser.service.XuqiuTypeService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-04-11
 */
@Service
public class XuqiuTypeServiceImpl extends ServiceImpl<XuqiuTypeMapper, XuqiuType> implements XuqiuTypeService {

    @Override
    public void add(String sort) {
        XuqiuType xuqiuType = new XuqiuType();
        xuqiuType.setName(sort);
        this.save(xuqiuType);
    }
}
