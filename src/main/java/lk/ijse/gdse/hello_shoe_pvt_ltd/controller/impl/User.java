package lk.ijse.gdse.hello_shoe_pvt_ltd.controller.impl;

import lk.ijse.gdse.hello_shoe_pvt_ltd.reqAndresp.authObj.AuthenticationService;
import lk.ijse.gdse.hello_shoe_pvt_ltd.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.hello_shoe_pvt_ltd.reqAndresp.secure.SignIn;
import lk.ijse.gdse.hello_shoe_pvt_ltd.reqAndresp.secure.SignUp;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class User {

    private final UserService userService;

    private final AuthenticationService authenticationService;


    //signup
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    //signin
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signIn) {
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @GetMapping("/role")
    public String getRole(@RequestParam String email) {
      return userService.getRole(email);
    }

}
