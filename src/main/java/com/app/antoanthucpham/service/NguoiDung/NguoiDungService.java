package com.app.antoanthucpham.service.NguoiDung;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.antoanthucpham.dto.request.NguoiDungDTO;
import com.app.antoanthucpham.exception.AlreadyExistsException;
import com.app.antoanthucpham.exception.NotFoundException;
import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.model.VaiTro;
import com.app.antoanthucpham.repository.NguoiDungRepository;
import com.app.antoanthucpham.repository.VaiTroRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NguoiDungService implements INguoiDungService {
    NguoiDungRepository nguoiDungRepository;
    VaiTroRepository vaiTroRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public NguoiDung addNguoiDung(NguoiDungDTO request) {
        String email = request.getEmail();
        String sdt = request.getSdt();
        if (nguoiDungRepository.existsByEmail(email)) {
            throw new AlreadyExistsException("Email đã tồn tại!");
        }
        if (nguoiDungRepository.existsBySdt(sdt)) {
            throw new AlreadyExistsException("Số điện thoại đã tồn tại!");
        }

        VaiTro vaiTro = vaiTroRepository.findById(request.getMaVaiTro())
                .orElseThrow(() -> new NotFoundException("Vai trò không tồn tại!"));

        NguoiDung user = new NguoiDung();
        user.setHoTen(request.getHoTen());
        user.setEmail(email);
        user.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        user.setSdt(sdt);
        user.setCccd(request.getCccd());
        user.setNgaySinh(request.getNgaySinh());
        user.setHoTen(request.getHoTen());
        user.setGioiTinh(request.isGioiTinh());
        user.setDiaChi(request.getDiaChi());
        user.setVaiTro(vaiTro);

        return nguoiDungRepository.save(user);
    }

}
