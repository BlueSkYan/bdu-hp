package xyz.blueskyan.bduhpcommon.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 同一返回值
 * @author Shijie Yan
 * @date 2023/2/10
 */
public class R extends HashMap<String, Object> implements Serializable {

    public static R success(){
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        return r;
    }

    public static R success(Object data){
        R r = new R();
        r.put("code", 0);
        r.put("msg", "success");
        r.put("data", data);
        return r;
    }

    public static R error(Object data){
        R r = new R();
        r.put("code", 1);
        r.put("msg", "error");
        r.put("data", data);
        return r;
    }

    public static R error(int code, Object data){
        R r = new R();
        r.put("code", code);
        r.put("msg", "error");
        r.put("data", data);
        return r;
    }
}
