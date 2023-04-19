package xyz.blueskyan.bduhpuser.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Shijie Yan
 * @since 2023-02-14
 */

@Data
@TableName("t_xuqiu")
@ApiModel(value = "YXuqiu对象", description = "")
public class Xuqiu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 需求标题、内容
     */
    @ApiModelProperty("内容")
    @TableField("title")
    private String title;

    /**
     * 跑腿 取货地址
     */
    @ApiModelProperty("取货地址")
    @TableField("qu_address")
    private String quAddress;

    /**
     * 跑腿 收货地址
     */
    @ApiModelProperty("收货地址")
    @TableField("shou_address")
    private String shouAddress;

    /**
     * 需求结束时间
     */
    @ApiModelProperty("结束时间")
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 描述信息
     */
    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    /**
     * 需求类型 0--跑腿；1--帮忙；2--其他
     */
    @ApiModelProperty("0--跑腿；1--帮忙；2--其他")
    @TableField("type")
    private Integer type;

    /**
     * 审核状态 0--未审核；1--审核通过；2--审核未通过
     */
    @ApiModelProperty("0--未审核；1--审核通过；2--审核未通过")
    @TableField("status")
    private Integer status;

    /**
     * 需求所属用户的id
     */
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    /**
     * 解决人的id
     */
    @ApiModelProperty("解决人的id")
    @TableField("solver_id")
    private Integer solverId;

    /**
     * 需求的赏金
     */
    @ApiModelProperty("需求赏金")
    @TableField("price")
    private BigDecimal price;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    @ApiModelProperty("1--删除；0--未删除")
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 评价
     */
    @ApiModelProperty("评价")
    @TableField("rate")
    private Integer rate;
}
