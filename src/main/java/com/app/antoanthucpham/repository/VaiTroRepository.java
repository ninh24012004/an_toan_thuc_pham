package com.app.antoanthucpham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.VaiTro;

@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {
}
