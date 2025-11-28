package com.vivian.graduation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "graduate_photos")
public class GraduatePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] content;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public byte[] getContent() { return content; }
    public void setContent(byte[] content) { this.content = content; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}
