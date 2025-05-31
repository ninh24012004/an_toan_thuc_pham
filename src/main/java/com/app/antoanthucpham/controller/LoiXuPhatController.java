package com.app.antoanthucpham.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.antoanthucpham.dto.request.LoiXuPhatDTO;
import com.app.antoanthucpham.model.LoiXuPhat;
import com.app.antoanthucpham.response.ApiResponse;
import com.app.antoanthucpham.service.LoiXuPhat.ILoiXuPhatService;

import jakarta.validation.Valid;

import static com.app.antoanthucpham.response.ResponseUtils.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/loixuphats")
public class LoiXuPhatController {
    ILoiXuPhatService loiXuPhatService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllLoiXuPhat() {
        List<LoiXuPhat> loiXuPhats = loiXuPhatService.getAllLoiXuPhats();
        return ok(loiXuPhats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getLoiXuPhatById(@PathVariable Long id) {
        LoiXuPhat loiXuPhat = loiXuPhatService.getLoiXuPhatById(id);
        return ok(loiXuPhat);
    }

    @PreAuthorize("hasRole('TRUONGBQL')")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addLoiXuPhat(@Valid @RequestBody LoiXuPhatDTO request) {
        LoiXuPhat loiXuPhat = loiXuPhatService.addLoiXuPhat(request);
        return ok(loiXuPhat);
    }

    @PreAuthorize("hasRole('TRUONGBQL')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteLoiXuPhat(@PathVariable Long id) {
        loiXuPhatService.deleteLoiXuPhat(id);
        return ok("Xóa lỗi xử phạt thành công");
    }

    @PreAuthorize("hasRole('TRUONGBQL')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateLoiXuPhat(
            @Valid @RequestBody LoiXuPhatDTO request, @PathVariable Long id) {
        LoiXuPhat loiXuPhat = loiXuPhatService.updateLoiXuPhat(request, id);
        return ok(loiXuPhat);
    }
}
