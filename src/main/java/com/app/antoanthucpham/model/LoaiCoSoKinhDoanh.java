package com.app.antoanthucpham.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class LoaiCoSoKinhDoanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maLoaiHinhKD;

    String tenLoaiHinhKD;

    @OneToMany(mappedBy = "loaiCoSoKinhDoanh")
    @JsonIgnore
    Set<CoSoKinhDoanh> coSoKinhDoanhs;
}