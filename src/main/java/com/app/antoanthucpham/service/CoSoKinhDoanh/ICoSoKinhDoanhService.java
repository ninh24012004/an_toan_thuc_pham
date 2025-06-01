package com.app.antoanthucpham.service.CoSoKinhDoanh;

import java.util.List;

import com.app.antoanthucpham.model.CoSoKinhDoanh;

public interface ICoSoKinhDoanhService {
    List<CoSoKinhDoanh> getAllCoSoKinhDoanhs();

    List<CoSoKinhDoanh> getCoSoKinhDoanhByName(String name);

    List<CoSoKinhDoanh> getCoSoKinhDoanhByMaNguoiDung(Long id);

    CoSoKinhDoanh getCoSoKinhDoanhById(Long id);

}
