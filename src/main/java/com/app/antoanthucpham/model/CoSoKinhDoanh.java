package com.app.antoanthucpham.model;

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
public class CoSoKinhDoanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maCoSoKD;

    String tenCoSoKD;
    String diaChiCoSoKD;

    @Column(unique = true)
    String sdt;

    @Column(unique = true)
    String email;
    String giayPhepKinhDoanh;
    String giayPhepVSTP;
    int soLanViPham;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "maLoaiHinhKD")
    LoaiCoSoKinhDoanh loaiCoSoKinhDoanh;

    @OneToMany(mappedBy = "coSoKinhDoanh", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<PhanAnh> phaAnhs;

    @OneToMany(mappedBy = "coSoKinhDoanh", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<ThamDinh> thamDinhs;

    @OneToMany(mappedBy = "coSoKinhDoanh", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<LichThanhTraCSKD> lichThanhTraCSKDs;
}
