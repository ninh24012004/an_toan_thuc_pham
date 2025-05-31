package com.app.antoanthucpham.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoiXuPhatDTO {
    @NotNull(message = "Tên lỗi xử phạt không được để trống")
    String tenLoi;

    @NotNull(message = "Tiền phạt không được để trống")
    @Positive(message = "Tiền phạt phải lớn hơn 0")
    BigDecimal tienPhat;
}
