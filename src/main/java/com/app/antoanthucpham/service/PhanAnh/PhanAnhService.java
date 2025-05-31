package com.app.antoanthucpham.service.PhanAnh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.antoanthucpham.dto.request.PhanAnhDTO;
import com.app.antoanthucpham.exception.NotFoundException;
import com.app.antoanthucpham.model.CoSoKinhDoanh;
import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.model.PhanAnh;
import com.app.antoanthucpham.repository.CoSoKinhDoanhRepository;
import com.app.antoanthucpham.repository.NguoiDungRepository;
import com.app.antoanthucpham.repository.PhanAnhRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PhanAnhService implements IPhanAnhService {
    PhanAnhRepository phanAnhRepository;
    CoSoKinhDoanhRepository coSoKinhDoanhRepository;
    NguoiDungRepository nguoiDungRepository;

    @Override
    public PhanAnh addPhanAnh(PhanAnhDTO request, MultipartFile file) {
        String imagePath = saveFile(file);

        CoSoKinhDoanh coSoKinhDoanh = coSoKinhDoanhRepository.findById(request.getMaCoSoKD())
                .orElseThrow(() -> new NotFoundException("Cơ sở kinh doanh không tồn tại!"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotFoundException("Người dùng chưa đăng nhập!");
        }
        String email = authentication.getName();

        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung == null) {
            throw new NotFoundException("Người dùng không tồn tại1!");
        }

        PhanAnh phanAnh = new PhanAnh();
        phanAnh.setNoiDung(request.getNoiDung());
        phanAnh.setHinhAnh(imagePath);
        phanAnh.setThoiGian(LocalDateTime.now());
        phanAnh.setNguoiDung(nguoiDung);
        phanAnh.setCoSoKinhDoanh(coSoKinhDoanh);

        return phanAnhRepository.save(phanAnh);
    }

    private String saveFile(MultipartFile file) {
        try {
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists())
                dir.mkdirs();

            String originalFileName = file.getOriginalFilename();
            String cleanFileName = removeVietnameseAndSpaces(originalFileName);
            String fileName = UUID.randomUUID() + "_" + cleanFileName;
            Path path = Paths.get(uploadDir + fileName);
            Files.copy(file.getInputStream(), path);

            return "/api/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi lưu file ảnh", e);
        }
    }

    private String removeVietnameseAndSpaces(String input) {
        String normalized = java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD);
        String noAccents = normalized.replaceAll("\\p{M}", "");
        String noSpaces = noAccents.replaceAll("\\s+", "_");
        return noSpaces.replaceAll("[^a-zA-Z0-9._-]", "");
    }
}
