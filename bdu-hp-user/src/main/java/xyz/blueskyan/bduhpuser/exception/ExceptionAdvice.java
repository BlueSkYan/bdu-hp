package xyz.blueskyan.bduhpuser.exception;

import cn.dev33.satoken.exception.NotLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.blueskyan.bduhpcommon.utils.R;

/**
 * @author Shijie Yan
 * @date 2023/2/13
 */
@RestControllerAdvice(basePackages = "xyz.blueskyan.bduhpuser.controller")
public class ExceptionAdvice {

    @ExceptionHandler(NotLoginException.class)
    public R handlerNotLoginException(NotLoginException nle){
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        }
        else {
            message = "当前会话未登录";
        }
        return R.error(message);
    }
}
