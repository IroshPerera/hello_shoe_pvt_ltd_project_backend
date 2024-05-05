package lk.ijse.gdse.hello_shoe_pvt_ltd.util.exeption;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
