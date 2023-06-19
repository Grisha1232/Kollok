package com.example.kollok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository userRepository;

    @Override
    public void create(NewActivity user) {
        userRepository.save(user);
    }

    @Override
    public List<NewActivity> readAll() {
        return userRepository.findAll();
    }

    @Override
    public NewActivity read(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public boolean update(NewActivity user, int id) {
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
