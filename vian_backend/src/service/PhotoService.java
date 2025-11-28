package com.vivian.graduation.service;

import com.vivian.graduation.model.GraduatePhoto;
import com.vivian.graduation.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public GraduatePhoto savePhoto(MultipartFile file) throws IOException {
        GraduatePhoto photo = new GraduatePhoto();
        photo.setFilename(file.getOriginalFilename());
        photo.setContent(file.getBytes());
        return photoRepository.save(photo);
    }

    public List<GraduatePhoto> getAllPhotos() {
        return photoRepository.findAll();
    }
}
