package com.app.antoanthucpham.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class ThamDinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maThamDinh;
    LocalDate ngayThamDinh;
    boolean trangThai;
    String hinhAnh;
    BigDecimal tongTienPhat;
    String noiDung;

    @ManyToOne
    @JoinColumn(name = "maCoSoKD")
    CoSoKinhDoanh coSoKinhDoanh;

    @OneToMany(mappedBy = "thamDinh")
    @JsonIgnore
    Set<ThamDinhLoi> thamDinhLois;
}
