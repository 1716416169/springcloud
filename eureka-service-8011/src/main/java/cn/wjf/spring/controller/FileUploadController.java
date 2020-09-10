package cn.wjf.spring.controller;

import cn.wjf.spring.tools.FileUpload;
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
}
