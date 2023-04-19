package xyz.blueskyan.bduhpuser.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Shijie Yan
 * @date 2023/3/4
 */
@Data
public class UserInfoAllVo implements Serializable {

    private Integer id;

    private String username;

    private String phoneNumber;

    private String userImage;

    private BigDecimal reward;

    private Boolean banned;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
