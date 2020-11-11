package cn.wjf.spring.controller;

import cn.wjf.spring.tools.FileUpload;
import cn.wjf.spring.tools.MultipartFileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileUploadController {



    @PostMapping("/file/POST")
    public Map<String,Object> uploadFile(MultipartFile file) throws Exception {
        FileUpload fileUpload = new FileUpload();
        HashMap<Object, Object> objectObjectHashMap = fileUpload.fileUpload(file);
        return null;
    }

    @PostMapping("/file2/POST")
    public Map<String,Object> uploadFile2(MultipartFile file) throws Exception {
        MultipartFileUtils multipartFileUtils = new MultipartFileUtils();
        Map<String, Object> upload = multipartFileUtils.Upload(file);
        return null;
    }
}
