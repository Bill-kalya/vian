package com.vivian.graduation.repository;

import com.vivian.graduation.model.GraduatePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<GraduatePhoto, Long> {
}
