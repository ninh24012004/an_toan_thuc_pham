package com.app.antoanthucpham.service.LoiXuPhat;

import java.util.List;

import com.app.antoanthucpham.dto.request.LoiXuPhatDTO;
import com.app.antoanthucpham.model.LoiXuPhat;

public interface ILoiXuPhatService {
    List<LoiXuPhat> getAllLoiXuPhats();

    LoiXuPhat getLoiXuPhatById(Long id);

    LoiXuPhat addLoiXuPhat(LoiXuPhatDTO request);

    LoiXuPhat updateLoiXuPhat(LoiXuPhatDTO request, Long id);

    void deleteLoiXuPhat(long id);
}
