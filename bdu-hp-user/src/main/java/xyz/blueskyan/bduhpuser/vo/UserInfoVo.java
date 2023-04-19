package xyz.blueskyan.bduhpuser.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shijie Yan
 * @date 2023/2/28
 */
@Data
public class UserInfoVo {

    private Integer id;

    private String username;

    private String userImage;

    private BigDecimal reward;
}
