package com.app.antoanthucpham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.PhanAnh;

@Repository
public interface PhanAnhRepository extends JpaRepository<PhanAnh, Long> {

}
