package com.app.antoanthucpham.model;

import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class LoiXuPhat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long maLoi;

    String tenLoi;
    BigDecimal tienPhat;

    @OneToMany(mappedBy = "loiXuPhat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<ThamDinhLoi> thamDinhLois;
}
