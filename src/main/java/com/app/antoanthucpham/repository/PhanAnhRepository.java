package com.app.antoanthucpham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.antoanthucpham.model.CoSoKinhDoanh;
import com.app.antoanthucpham.model.PhanAnh;

@Repository
public interface PhanAnhRepository extends JpaRepository<PhanAnh, Long> {
    List<PhanAnh> findByCoSoKinhDoanhIn(List<CoSoKinhDoanh> coSoKinhDoanhs);
}
