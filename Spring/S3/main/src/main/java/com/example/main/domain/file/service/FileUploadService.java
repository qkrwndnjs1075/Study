package com.example.main.domain.file.service;

import com.example.main.domain.file.exception.FailFileException;
import com.example.main.global.infrastructure.s3.AwsS3Properties;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Exception;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Component
class FileUploadService {

    private final AwsS3Properties s3Properties;
    private final S3Operations s3Operations;

    void uploadFile(MultipartFile multipartFile, String key){
        try {
            s3Operations.upload(
                    s3Properties.bucket(),
                    key,
                    multipartFile.getInputStream(),
                    ObjectMetadata.builder()
                            .contentType(multipartFile.getContentType())
                            .build()
            );
        } catch (IOException e) {
            // IOException에 대한 처리
            throw new RuntimeException("파일 업로드 중 문제가 발생했습니다: " + e.getMessage(), e);
        } catch (S3Exception e) {
            // S3 관련 문제 처리
            throw new RuntimeException("S3에 파일 업로드 중 오류가 발생했습니다: " + e.getMessage(), e);
        } catch (Exception e) {
            // 기타 예외 처리
            throw new RuntimeException("예상치 못한 오류 발생: " + e.getMessage(), e);
        }

    }
}
