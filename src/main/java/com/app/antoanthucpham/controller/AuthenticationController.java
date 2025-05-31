package com.app.antoanthucpham.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.antoanthucpham.dto.request.LoginRequest;
import com.app.antoanthucpham.dto.response.JwtResponse;
import com.app.antoanthucpham.exception.NotFoundException;
import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.repository.NguoiDungRepository;
import com.app.antoanthucpham.security.JwtUtil;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationManager authenticationManager;
    NguoiDungRepository nguoiDungRepository;
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMatKhau()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        NguoiDung user = nguoiDungRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new NotFoundException("Email hoặc mật khẩu không đúng");
        }

        String token = jwtUtil.generateToken(request.getEmail(), user.getVaiTro().getTenVaiTro());

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
