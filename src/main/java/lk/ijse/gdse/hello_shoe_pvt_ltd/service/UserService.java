package lk.ijse.gdse.hello_shoe_pvt_ltd.service;


import lk.ijse.gdse.hello_shoe_pvt_ltd.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void saveUser(UserDTO userDTO);
}
