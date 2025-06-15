package com.app.antoanthucpham.controller;

import static com.app.antoanthucpham.response.ResponseUtils.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.antoanthucpham.dto.request.PhanAnhDTO;
import com.app.antoanthucpham.model.PhanAnh;
import com.app.antoanthucpham.response.ApiResponse;
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
    public ResponseEntity<ApiResponse> themPhanAnh(
            @RequestParam MultipartFile file,
            @RequestParam String noiDung,
            @RequestParam Long maCoSoKD) {

        PhanAnhDTO dto = new PhanAnhDTO();
        dto.setNoiDung(noiDung);
        dto.setMaCoSoKD(maCoSoKD);

        PhanAnh phanAnh = phanAnhService.addPhanAnh(dto, file);
        return ok(phanAnh);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPhanAnhs() {
        List<PhanAnh> phanAnhs = phanAnhService.getAllPhanAnhs();
        return ok(phanAnhs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getPhanAnhById(@PathVariable Long id) {
        PhanAnh phanAnh = phanAnhService.getPhanAnhById(id);
        return ok(phanAnh);
    }

    @GetMapping("/getbychu")
    public ResponseEntity<ApiResponse> getPhanAnhByChuCoSo() {
        List<PhanAnh> phanAnhs = phanAnhService.getPhanAnhByChuCoSo();
        return ok(phanAnhs);
    }
}
