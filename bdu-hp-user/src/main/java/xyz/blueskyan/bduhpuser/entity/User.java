package xyz.blueskyan.bduhpuser.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author blueskyan
 * @since 2023-02-10
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("phone_number")
    private String phoneNumber;

    @TableLogic
    @ApiModelProperty("1--删除；0--未删除")
    @TableField("deleted")
    private Boolean deleted;

    @ApiModelProperty("账号状态；1--封禁；0--正常")
    @TableField("banned")
    private Boolean banned;
}
