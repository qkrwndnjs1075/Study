package com.example.main.domain.file.service;

import com.example.main.global.infrastructure.s3.AwsS3Properties;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
class FileUploadService {

    private final AwsS3Properties s3Properties;
    private final S3Operations s3Operations;

    void uploadFile(MultipartFile multipartFile, String key){
        try{
            s3Operations.upload(
                    s3Properties.bucket(),
                    key,
                    multipartFile.getInputStream(),
                    ObjectMetadata.builder()
                            .contentType(multipartFile.getContentType())
                            .build()
            );
        }catch (Exception e){
            throw new RuntimeException(); // 나중에 바꾸기
        }
    }
}
