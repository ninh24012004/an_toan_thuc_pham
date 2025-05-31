package com.app.antoanthucpham.service.LoiXuPhat;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.antoanthucpham.dto.request.LoiXuPhatDTO;
import com.app.antoanthucpham.exception.AlreadyExistsException;
import com.app.antoanthucpham.exception.NotFoundException;
import com.app.antoanthucpham.model.LoiXuPhat;
import com.app.antoanthucpham.repository.LoiXuPhatRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoiXuPhatService implements ILoiXuPhatService {
    LoiXuPhatRepository loiXuPhatRepository;

    @Override
    public List<LoiXuPhat> getAllLoiXuPhats() {
        return loiXuPhatRepository.findAll();
    }

    @Override
    public LoiXuPhat getLoiXuPhatById(Long id) {
        return loiXuPhatRepository.findById(id).orElseThrow(() -> new NotFoundException("Lỗi xử phạt không tồn tại!"));
    }

    @Override
    public LoiXuPhat addLoiXuPhat(LoiXuPhatDTO request) {
        String tenLoi = request.getTenLoi();

        if (loiXuPhatRepository.existsByTenLoi(tenLoi)) {
            throw new AlreadyExistsException("Tên lỗi đã tồn tại!");
        }

        LoiXuPhat loiXuPhat = new LoiXuPhat();
        loiXuPhat.setTenLoi(tenLoi);
        loiXuPhat.setTienPhat(request.getTienPhat());

        return loiXuPhatRepository.save(loiXuPhat);
    }

    @Override
    public LoiXuPhat updateLoiXuPhat(LoiXuPhatDTO request, Long id) {

        LoiXuPhat oldLoiXuPhat = getLoiXuPhatById(id);

        String tenLoi = request.getTenLoi();
        if (!oldLoiXuPhat.getTenLoi().equalsIgnoreCase(tenLoi) &&
                loiXuPhatRepository.existsByTenLoi(tenLoi)) {
            throw new AlreadyExistsException("Tên lỗi xử phạt đã tồn tại!");
        }

        oldLoiXuPhat.setTenLoi(tenLoi);
        oldLoiXuPhat.setTienPhat(request.getTienPhat());

        return loiXuPhatRepository.save(oldLoiXuPhat);
    }

    @Override
    public void deleteLoiXuPhat(long id) {
        LoiXuPhat loiXuPhat = getLoiXuPhatById(id);

        loiXuPhatRepository.delete(loiXuPhat);
    }

}
