package com.app.antoanthucpham.service.NguoiDung;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.antoanthucpham.model.NguoiDung;
import com.app.antoanthucpham.repository.NguoiDungRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomUserDetailsService implements UserDetailsService {
    NguoiDungRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        NguoiDung user = nguoiDungRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy user với email: " + email);
        }

        return new User(
                user.getEmail(),
                user.getMatKhau(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getVaiTro().getMaVaiTro())));
    }
}
