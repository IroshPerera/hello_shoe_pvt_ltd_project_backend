package lk.ijse.gdse.hello_shoe_pvt_ltd.service;


import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    void saveUser(UserDTO userDTO);

    String getRole(String email);

    String getEmployeeCode(String cashierName);

    List<UserDTO> getAllUsers();

    boolean deleteUser(String email);
}
