package com.vivian.graduation.controller;

import com.vivian.graduation.model.GraduatePhoto;
import com.vivian.graduation.service.PhotoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin("*") // Allow frontend on different port to access
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            photoService.savePhoto(file);
            return "Photo uploaded successfully!";
        } catch (Exception e) {
            return "Failed to upload photo: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<String> getAllPhotos() {
        List<GraduatePhoto> photos = photoService.getAllPhotos();
        return photos.stream()
                .map(photo -> "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(photo.getContent()))
                .collect(Collectors.toList());
    }
}
