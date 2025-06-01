package com.app.antoanthucpham.service.CoSoKinhDoanh;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.antoanthucpham.exception.NotFoundException;
import com.app.antoanthucpham.model.CoSoKinhDoanh;
import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.repository.CoSoKinhDoanhRepository;
import com.app.antoanthucpham.repository.NguoiDungRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CoSoKinhDoanhService implements ICoSoKinhDoanhService {
    CoSoKinhDoanhRepository coSoKinhDoanhRepository;
    NguoiDungRepository nguoiDungRepository;

    @Override
    public List<CoSoKinhDoanh> getAllCoSoKinhDoanhs() {
        return coSoKinhDoanhRepository.findAll();
    }

    @Override
    public List<CoSoKinhDoanh> getCoSoKinhDoanhByName(String name) {
        return coSoKinhDoanhRepository.findByTenCoSoKDContainingIgnoreCase(name);
    }

    @Override
    public List<CoSoKinhDoanh> getCoSoKinhDoanhByMaNguoiDung(Long id) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nguời dùng không tồn tại!"));

        return coSoKinhDoanhRepository.findByNguoiDung(nguoiDung);
    }

    @Override
    public CoSoKinhDoanh getCoSoKinhDoanhById(Long id) {
        return coSoKinhDoanhRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cơ sở kinh doanh không tồn tại!"));
    }

}
