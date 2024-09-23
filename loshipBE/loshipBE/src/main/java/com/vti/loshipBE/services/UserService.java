package com.vti.loshipBE.services;

import com.vti.loshipBE.database.SequenceGeneratorService;
import com.vti.loshipBE.models.User;
import com.vti.loshipBE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public User create(User newUser){
        Long id = sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);
        newUser.setId(id);
        return userRepository.insert(newUser);
    }

    public User update(User updateUser){
        Optional<User> optionalUser = userRepository.findById(updateUser.getId());

        if(optionalUser.isEmpty()) return null;
        return userRepository.save(updateUser);
    }

    public boolean checkExistEmail(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()) return true;
        return false;
    }

    public boolean checkExistEmailOrPassword(String email, String phone){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        Optional<User> optionalPhone = userRepository.findByPhone(phone);

        if(optionalUser.isPresent()) return true;
        if(optionalPhone.isPresent()) return true;

        return false;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
