package com.app.antoanthucpham.controller;

import static com.app.antoanthucpham.response.ResponseUtils.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.antoanthucpham.dto.request.NguoiDungDTO;
import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.response.ApiResponse;
import com.app.antoanthucpham.service.NguoiDung.INguoiDungService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/nguoidungs")
public class NguoiDungController {
    INguoiDungService nguoiDungService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addNguoiDung(@Valid @RequestBody NguoiDungDTO request) {
        NguoiDung nguoiDung = nguoiDungService.addNguoiDung(request);
        return ok(nguoiDung);
    }

    @GetMapping("/getbyemail")
    public ResponseEntity<ApiResponse> getNguoiDungByEmail(@RequestParam String email) {
        NguoiDung nguoiDung = nguoiDungService.getNguoiDungByEmail(email);
        return ok(nguoiDung);
    }
}
