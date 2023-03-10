package xyz.ccola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.ccola.common.OssTemplate;
import xyz.ccola.common.VodTemplate;

import java.io.IOException;

/**
 * @ Name: UploadController
 * @ Author: Cola
 * @ Time: 2022/12/16 19:50
 * @ Description: UploadController
 */
@RestController
@RequestMapping("/admin/upload")
public class UploadController {
    @Autowired
    private OssTemplate ossTemplate;
    @Autowired
    private VodTemplate vodTemplate;

    /**
     * 图片上传
     * @param uploadImage Image
     * @return ImagePath
     * @throws IOException IOException
     */
    @RequestMapping("/image")
    public String uploadImage(MultipartFile uploadImage) throws IOException {
        String imagePath = ossTemplate.upload(uploadImage.getOriginalFilename(), uploadImage.getInputStream());
        return imagePath;
    }

    /**
     * 视频上传
     * @param uploadVideo uploadVideo
     * @return playId
     * @throws IOException IOException
     */
    @RequestMapping("/video")
    public String uploadVideo(MultipartFile uploadVideo) throws IOException {
        String playId = vodTemplate.uploadVideo(uploadVideo.getOriginalFilename(), uploadVideo.getInputStream());

        return playId;
    }


}
