package com.example.main.domain.file.domain.controller;

import com.example.main.domain.file.domain.dto.FileResponse;
import com.example.main.domain.file.domain.type.ImageType;
import com.example.main.domain.file.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController{

    private final ImageService imageService;

    @PostMapping("/image")
    FileResponse uploadImage(@RequestPart("file") MultipartFile multipartFile, @RequestParam("type") ImageType imagetype){
        String path = imageService.saveImage(multipartFile, imagetype);
        return new FileResponse(imageService.getFileBaseUrl() + path, multipartFile.getOriginalFilename());
    }

}
