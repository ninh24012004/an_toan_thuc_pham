package com.app.antoanthucpham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.CoSoKinhDoanh;
import com.app.antoanthucpham.model.NguoiDung;

@Repository
public interface CoSoKinhDoanhRepository extends JpaRepository<CoSoKinhDoanh, Long> {
    List<CoSoKinhDoanh> findByTenCoSoKDContainingIgnoreCase(String keyword);

    List<CoSoKinhDoanh> findByNguoiDung(NguoiDung nguoiDung);
}
