package cn.wjf.spring.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MultipartFileUtils {

    public Map<String,Object> Upload(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newName=UUID.randomUUID()+suffix;
        String pic = new File("pic").getAbsolutePath();
        String newFilePath=pic+"/"+newName;
        File file = new File(newFilePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        multipartFile.transferTo(file);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        return null;

    }
}
