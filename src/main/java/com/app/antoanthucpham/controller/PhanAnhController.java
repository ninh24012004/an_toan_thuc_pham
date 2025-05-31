package com.app.antoanthucpham.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.antoanthucpham.dto.request.PhanAnhDTO;
import com.app.antoanthucpham.model.PhanAnh;
import com.app.antoanthucpham.service.PhanAnh.IPhanAnhService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/phananhs")
public class PhanAnhController {
    IPhanAnhService phanAnhService;

    @PostMapping("/add")
    public ResponseEntity<PhanAnh> themPhanAnh(
            @RequestParam MultipartFile file,
            @RequestParam String noiDung,
            @RequestParam Long maCoSoKD) {

        PhanAnhDTO dto = new PhanAnhDTO();
        dto.setNoiDung(noiDung);
        dto.setMaCoSoKD(maCoSoKD);

        PhanAnh phanAnh = phanAnhService.addPhanAnh(dto, file);
        return ResponseEntity.ok(phanAnh);
    }
}
