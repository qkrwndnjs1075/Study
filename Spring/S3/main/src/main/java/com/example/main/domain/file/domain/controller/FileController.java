package com.example.main.domain.file.domain.controller;

import com.example.main.domain.file.domain.dto.FileResponse;
import com.example.main.domain.file.domain.type.ImageType;
import com.example.main.domain.file.service.ImageService;
import com.example.main.global.common.swagger.SwaggerBlog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final ImageService imageService;

    @PostMapping("/image")
    @ResponseStatus(HttpStatus.CREATED)
    FileResponse uploadImage(@RequestPart("file") MultipartFile filePart, @RequestParam("type") ImageType imageType) {
        String path = imageService.saveImage(filePart, imageType);
        return new FileResponse(imageService.getFileBaseUrl() + path, filePart.getOriginalFilename());
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteImage(@RequestParam String url) {
        imageService.deleteImage(url);
    }

}
