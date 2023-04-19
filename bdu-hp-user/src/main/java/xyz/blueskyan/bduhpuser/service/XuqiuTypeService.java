package xyz.blueskyan.bduhpuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.blueskyan.bduhpuser.entity.XuqiuType;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-04-11
 */
public interface XuqiuTypeService extends IService<XuqiuType> {

    /**
     * 增加种类
     * @param sort
     */
    void add(String sort);
}
