package com.app.antoanthucpham.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maNguoiDung;

    @Column(unique = true)
    String email;

    String matKhau;
    String hoTen;

    @Column(unique = true)
    String sdt;

    @Column(unique = true)
    String cccd;
    boolean gioiTinh;
    String diaChi;
    LocalDate ngaySinh;
    boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "maVaiTro")
    VaiTro vaiTro;

    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<PhanAnh> phanAnhs;

    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<CoSoKinhDoanh> coSoKinhDoanhs;

    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<DangKiGiayPhep> dangKiGiayPheps;

    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<LichThanhTra> lichThanhTras;
}
