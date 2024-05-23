package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.UserDTO;
import lk.ijse.gdse.hello_shoe_pvt_ltd.entity.UserEntity;
import lk.ijse.gdse.hello_shoe_pvt_ltd.repository.UserRepo;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.UserService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.util.map.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {


    private final UserRepo userRepo;
    private final Mapping mapping;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void saveUser(UserDTO userDTO) {

        mapping.toUserDTO(userRepo.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public String getRole(String email) {
        return userRepo.findByEmail(email)
                .map(userEntity -> userEntity.getRole().name())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @Override
    public String getEmployeeCode(String cashierName) {
        Optional<UserEntity> user = userRepo.findByEmail(cashierName);
        return user.map(UserEntity::getEmployee_code).orElse(null);

    }
}

