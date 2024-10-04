package SpringMVC.Service;

import SpringMVC.Dto.UserDTO;
import SpringMVC.Entity.User;
import SpringMVC.Mapper.UserMapper;
import SpringMVC.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetDataUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper  userMapper;
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(Long id , User updateUser){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setEmail(updateUser.getEmail());
            user.setUsername(updateUser.getUsername());
            user.setNumberphone(updateUser.getNumberphone());
            userRepository.save(user);
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> searchUsersByUsername(String username){
        return userRepository.findByUsername(username);
    }
}