package xyz.blueskyan.bduhpuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.blueskyan.bduhpuser.entity.Xuqiu;
import xyz.blueskyan.bduhpuser.mapper.XuqiuMapper;
import xyz.blueskyan.bduhpuser.service.XuqiuService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-14
 */
@Service
public class XuqiuServiceImpl extends ServiceImpl<XuqiuMapper, Xuqiu> implements XuqiuService {

    @Override
    public List<Xuqiu> listByStatus() {
        QueryWrapper<Xuqiu> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 1).isNull("solver_id").orderByDesc("id");
        return this.list(wrapper);
    }

    @Override
    public List<Xuqiu> listByUserId(String userId) {
        QueryWrapper<Xuqiu> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).orderByDesc("id");
        return this.list(wrapper);
    }

    @Override
    public List<Xuqiu> listBySolverId(String userId) {
        QueryWrapper<Xuqiu> wrapper = new QueryWrapper<>();
        wrapper.eq("solver_id", userId).orderByDesc("id");
        return this.list(wrapper);
    }

    @Override
    public void goToHelp(int id, int userId) {
        Xuqiu xuqiu = new Xuqiu();
        xuqiu.setId(id);
        xuqiu.setSolverId(userId);
        this.updateById(xuqiu);
    }

    @Override
    public List<Xuqiu> listByDesc() {
        return this.list(new QueryWrapper<Xuqiu>().orderByDesc("id"));
    }

    @Override
    public void approveById(Integer id) {
        Xuqiu xuqiu = new Xuqiu();
        xuqiu.setId(id);
        xuqiu.setStatus(1);
        this.updateById(xuqiu);
    }

    @Override
    public void notApproveById(Integer id) {
        Xuqiu xuqiu = new Xuqiu();
        xuqiu.setId(id);
        xuqiu.setStatus(2);
        this.updateById(xuqiu);
    }

}
