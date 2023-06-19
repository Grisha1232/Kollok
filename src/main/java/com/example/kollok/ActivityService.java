package com.example.kollok;

import java.util.List;

public interface ActivityService {
    void create(NewActivity user);
    List<NewActivity> readAll();
    NewActivity read(int id);
    boolean update(NewActivity user, int id);
    boolean delete(int id);
}
