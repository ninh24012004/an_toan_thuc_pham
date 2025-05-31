package com.app.antoanthucpham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.LoiXuPhat;

@Repository
public interface LoiXuPhatRepository extends JpaRepository<LoiXuPhat, Long> {
    boolean existsByTenLoi(String tenLoi);
}
