package com.example.main.domain.file.service;

import com.example.main.domain.file.exception.FailFileException;
import com.example.main.global.infrastructure.s3.AwsS3Properties;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Exception;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
class FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadService.class);

    private final S3Operations s3Operations;
    private final AwsS3Properties s3Properties;

    void uploadFile(MultipartFile multipartFile, String key) {
        try {
            // S3 파일 업로드 처리
            s3Operations.upload(
                    s3Properties.bucket(),
                    key,
                    multipartFile.getInputStream(),
                    ObjectMetadata.builder()
                            .contentType(multipartFile.getContentType())
                            .build()
            );
            logger.info("File uploaded successfully to S3 with key: {}", key);
        } catch (IOException e) {
            // 파일 업로드 관련 I/O 예외 처리
            logger.error("File upload failed due to I/O error: {}", e.getMessage(), e);

        } catch (S3Exception e) {
            // S3 관련 오류 처리
            logger.error("S3 upload failed: {}", e.getMessage(), e);

        } catch (Exception e) {
            // 기타 예기치 못한 예외 처리
            logger.error("Unexpected error during file upload: {}", e.getMessage(), e);

        }
    }
}
