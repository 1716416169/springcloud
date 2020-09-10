package cn.wjf.spring.tools;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
;
import java.util.HashMap;
import java.util.UUID;

public class FileUpload {
    public HashMap<Object, Object> fileUpload(MultipartFile file) throws Exception {

        /*得到文件的原始名字*/
        String oldFileName = file.getOriginalFilename();
        /*截取到文件的后缀名*/
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        /*随机一个新的文件名*/
        String newFileName = UUID.randomUUID() + eName;
        /*当前路径下pic文件夹的绝对路径*/
        String pic = new File("pic").getAbsolutePath();
        /*pic和文件名拼接好的目标文件的绝对路径*/
        File dest = new File(pic+ "/" +newFileName);
        /*判断文件夹是否存在*/
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        /*将数据传输到目标文件路径dest*/
        file.transferTo(dest);
        System.out.println("第一次存放的路径："+dest);



        // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
        MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", "wjf", "weijianfeng666");
        // 检查存储桶是否已经存在
        boolean isExist = minioClient.bucketExists("pic-one");
        if (isExist) {
            System.out.println("桶已存在！！！");
        } else {
            // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
            minioClient.makeBucket("pic-one");
        }
        // 使用putObject上传一个文件到存储桶中。
        minioClient.putObject("pic-one", newFileName+"", ""+dest);

        return null;
    }

}
