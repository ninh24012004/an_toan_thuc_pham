package com.app.antoanthucpham.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKiGiayPhep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maDanhKy;

    String donDeNghi;
    String banThuyetTrinh;
    String giayTapHuan;
    String giaySucKhoe;
    String giayPhepKinhDoanh;
    LocalDate ngayDangKi;
    LocalDate ngayHetHan;
    LocalDate ngayCapGiayPhep;
    boolean trangThaiGiayPhep;
    String ghiChu;
    boolean trangThaiThanhTra;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    NguoiDung nguoiDung;
}
