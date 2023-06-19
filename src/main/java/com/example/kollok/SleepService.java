package com.example.kollok;

import java.util.List;

public interface SleepService {
    void create(NewSleep user);
    List<NewSleep> readAll();
    NewSleep read(int id);
    boolean update(NewSleep user, int id);
    boolean delete(int id);
}
