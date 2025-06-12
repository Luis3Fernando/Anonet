package com.louis.anonet.user;
import com.louis.anonet.user.UserRepository;
import com.louis.anonet.user.dto.UserRequest;
import com.louis.anonet.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final long ACTIVITY_TIMEOUT_SECONDS = 180;

    public User createUser (UserRequest request){
        if (userRepository.findByAlias(request.alias()).isPresent()){
            throw new IllegalArgumentException("Alias already in use");
        }

        User user = new User();
        user.setAlias(request.alias());
        userRepository.save(user);
        return user;
    }
}