package xyz.blueskyan.bduhpuser.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

@Component
public class NameUtil {
    public String getNanoId(String oName){
        String suf = FilenameUtils.getExtension(oName);
        return NanoIdUtils.randomNanoId() + "." + suf;
    }
}
