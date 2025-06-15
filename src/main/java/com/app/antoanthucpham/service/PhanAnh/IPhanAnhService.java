package com.app.antoanthucpham.service.PhanAnh;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.antoanthucpham.dto.request.PhanAnhDTO;
import com.app.antoanthucpham.model.PhanAnh;

public interface IPhanAnhService {
    PhanAnh addPhanAnh(PhanAnhDTO request, MultipartFile file);

    List<PhanAnh> getAllPhanAnhs();

    PhanAnh getPhanAnhById(Long id);

    List<PhanAnh> getPhanAnhByChuCoSo();
}
