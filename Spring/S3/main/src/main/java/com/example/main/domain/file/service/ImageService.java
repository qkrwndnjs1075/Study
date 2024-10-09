package com.example.main.domain.file.service;

import com.example.main.domain.file.domain.type.ImageType;
import com.example.main.global.infrastructure.s3.AwsS3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ImageService {

    private static final Set<String> TYPE_PHOTO = Set.of(".jpg", ".jpeg", ".png",".heic",".svg",".gif");

    private final AwsS3Properties awsS3Properties;
    private final FileUploadService fileUploadService;
    private final FileDeleteService fileDeleteService;

    @Transactional
    public String saveImage(MultipartFile multipartFile, ImageType imageType){
        String originalFilename = multipartFile.getOriginalFilename();
        if(originalFilename == null || !isValidExtension(getExtension(originalFilename))){
            throw new RuntimeException("Invalid file extension");
        }
            String key = gener


    }

    public boolean isValidExtension(String contains){
        return TYPE_PHOTO.contains(contains);
    }

    public String getExtension(String filename){
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }

    public String generateFile(ImageType imageType){
        String folder = imageType == ImageType.profile ? awsS3Properties.profileFolder() : awsS3Properties.blogFolder(){
            return a
        }

    }
}
