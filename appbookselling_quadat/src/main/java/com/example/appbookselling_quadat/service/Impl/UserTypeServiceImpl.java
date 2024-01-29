package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.UserTypeResponse;
import com.example.appbookselling_quadat.entity.UserType;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.UserTypeMapper;
import com.example.appbookselling_quadat.repository.UserTypeRepository;
import com.example.appbookselling_quadat.service.UserTypeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserTypeResponse> getUserTypeList() {
        List<UserType> userTypes = userTypeRepository.findAll();
        return userTypes.stream().map(UserTypeMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserTypeResponse getDetailUserType(int id) throws NotFoundException {
        UserType userType = userTypeRepository.findUserTypeById(id);
        if(Objects.isNull(userType)){
            throw new NotFoundException("Not Found Object in Database");
        }
        return UserTypeMapper.convertToResponse(userType);
    }

    @Override
    public void createUserType(UserType obj) {
        UserType userType = userTypeRepository.findUserTypeByTypeName(obj.getTypeName());
        if(!Objects.isNull(userType)){
            throw new DuplicateException("TypeName exist in Database");
        }
        else {
            userTypeRepository.save(obj);
        }
    }

    @Override
    public void updateUserType(UserType obj) {
        UserType userType = userTypeRepository.findUserTypeByTypeName(obj.getTypeName());
        if(!Objects.isNull(userType)){
            throw new DuplicateException("TypeName exist in Database");
        }
        else {
            userTypeRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        UserType userType = userTypeRepository.findUserTypeById(id);
        if(Objects.isNull(userType)){
            throw new NotFoundException("Not Found Object in Database");
        }
        else {
            userTypeRepository.delete(userType);
        }
    }
}
