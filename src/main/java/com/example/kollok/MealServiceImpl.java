package com.example.kollok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository userRepository;

    @Override
    public void create(NewMeal user) {
        userRepository.save(user);
    }

    @Override
    public List<NewMeal> readAll() {
        return userRepository.findAll();
    }

    @Override
    public NewMeal read(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public boolean update(NewMeal user, int id) {
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
