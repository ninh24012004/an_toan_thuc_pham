package com.app.antoanthucpham.controller;

import static com.app.antoanthucpham.response.ResponseUtils.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.antoanthucpham.model.CoSoKinhDoanh;
import com.app.antoanthucpham.response.ApiResponse;
import com.app.antoanthucpham.service.CoSoKinhDoanh.ICoSoKinhDoanhService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/cosokinhdoanhs")
public class CoSoKinhDoanhController {
    ICoSoKinhDoanhService coSoKinhDoanhService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCoSoKinhDoanh() {
        List<CoSoKinhDoanh> coSoKinhDoanhs = coSoKinhDoanhService.getAllCoSoKinhDoanhs();
        return ok(coSoKinhDoanhs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCoSoKinhDoanhById(@PathVariable Long id) {
        CoSoKinhDoanh coSoKinhDoanh = coSoKinhDoanhService.getCoSoKinhDoanhById(id);
        return ok(coSoKinhDoanh);
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<ApiResponse> getCoSoKinhDoanhByName(@PathVariable String name) {
        List<CoSoKinhDoanh> coSoKinhDoanhs = coSoKinhDoanhService.getCoSoKinhDoanhByName(name);
        return ok(coSoKinhDoanhs);
    }

    @GetMapping("/getbynguoidung/{id}")
    public ResponseEntity<ApiResponse> getCoSoKinhDoanhByMaNguoiDung(@PathVariable Long id) {
        List<CoSoKinhDoanh> coSoKinhDoanhs = coSoKinhDoanhService.getCoSoKinhDoanhByMaNguoiDung(id);
        return ok(coSoKinhDoanhs);
    }
}
