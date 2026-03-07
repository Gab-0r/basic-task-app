package com.example.tasksapp.Service;


import com.example.tasksapp.Model.User;
import com.example.tasksapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not foundd"));
    }

    public User save(User user){
        return repository.save(user);
    }

    public User update(Long id, User user){
        return repository.findById(id).map(existing -> {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
