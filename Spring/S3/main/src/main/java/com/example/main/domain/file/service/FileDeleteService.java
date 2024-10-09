package com.example.main.domain.file.service;

import com.example.main.global.infrastructure.s3.AwsS3Properties;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FileDeleteService {

    private final S3Operations s3Operations;
    private final AwsS3Properties s3Properties;

    void deleteKey(String key){
        s3Operations.deleteObject(s3Properties.bucket(), key);
    }
}
