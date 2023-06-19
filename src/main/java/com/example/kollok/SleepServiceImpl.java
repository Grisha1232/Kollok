package com.example.kollok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepServiceImpl implements SleepService {

    @Autowired
    private SleepRepository userRepository;

    @Override
    public void create(NewSleep user) {
        userRepository.save(user);
    }

    @Override
    public List<NewSleep> readAll() {
        return userRepository.findAll();
    }

    @Override
    public NewSleep read(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public boolean update(NewSleep user, int id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
