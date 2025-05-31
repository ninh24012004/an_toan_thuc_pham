package com.app.antoanthucpham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long> {
    boolean existsByEmail(String email);

    boolean existsBySdt(String sdt);

    NguoiDung findByEmail(String email);
}
