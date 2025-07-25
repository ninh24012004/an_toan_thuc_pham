package com.app.antoanthucpham.service.NguoiDung;

import java.util.List;

import com.app.antoanthucpham.dto.request.NguoiDungDTO;
import com.app.antoanthucpham.model.NguoiDung;

public interface INguoiDungService {
    NguoiDung addNguoiDung(NguoiDungDTO request);

    NguoiDung getNguoiDungByEmail(String email);

    List<NguoiDung> getAllNguoiDung();
}