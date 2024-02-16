package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.UserResponse;
import com.example.appbookselling_quadat.entity.User;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.UserMapper;
import com.example.appbookselling_quadat.repository.UserRepository;
import com.example.appbookselling_quadat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public List<UserResponse> getUserList() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getDetailUser(int id) throws NotFoundException {
        User user = userRepository.findUserById(id);
        if (Objects.isNull(user)){
            throw new NotFoundException("Not Found Object in Database");
        }
        return UserMapper.convertToResponse(user);
    }

    @Override
    public void createUser(User obj) {
        User user = userRepository.findUserByUsername(obj.getUsername());
        if (!Objects.isNull(user)){
            throw new DuplicateException("Username exist in Database");
        }
        else {
            userRepository.save(obj);
        }
    }

    @Override
    public void updateUser(User obj) {
        User user = userRepository.findUserByUsername(obj.getUsername());
        if (!Objects.isNull(user)){
            throw new DuplicateException("Username exist in Database");
        }
        else {
            userRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findUserById(id);
        if (Objects.isNull(user)){
            throw new NotFoundException("Not Found Object in Database");
        }
        else {
            userRepository.delete(user);
        }
    }
}
