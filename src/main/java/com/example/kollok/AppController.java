package com.example.kollok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
public class AppController {

    private final ActivityService activityService;
    private final MealService mealService;
    private final SleepService sleepService;

    @Autowired
    public AppController(ActivityService activityService, MealService mealService, SleepService sleepService) {
        this.activityService = activityService;
        this.mealService = mealService;
        this.sleepService = sleepService;
    }

    // Создать новую запись о активности
    @PostMapping("/activity")
    public ResponseEntity<String> postNewActivity(@RequestBody NewActivity request) {
        // для добавление очередной записи присваиваем id дальше
        Integer id = 0;
        var dummy = activityService.readAll();
        if (dummy.size() > 0) {
            id = dummy.get(dummy.size() - 1).getId(); // вот тут
        }

        String kind = request.getActivity_kind();
        Integer sec = request.getSeconds();
        Integer kalo = request.getKalories();

        // проверка на корректность
        if (Objects.equals(kind, "")) {
            return ResponseEntity.badRequest().body("Name activity cannot be ''");
        }
        if (sec <= 0) {
            return ResponseEntity.badRequest().body("Seconds cannot be less or equal then zero");
        }

        if (kalo <= 0) {
            return ResponseEntity.badRequest().body("Kalories cannot be less or equal then zero");
        }
        request.setId(id + 1);
        activityService.create(request);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/nutrition")
    public ResponseEntity<String> postNewMeal(@RequestBody NewMeal request) {
        Integer id = 0;
        var dummy = mealService.readAll();
        if (dummy.size() > 0) {
            id = dummy.get(dummy.size() - 1).getId();
        }
        String name = request.getName();
        Integer gramms = request.getGramms();
        Integer kalories = request.getKalories();

        // проверка на корректность
        if (name.equals("")) {
            return ResponseEntity.badRequest().body("Name cannot be ''");
        }
        if (gramms <= 0) {
            return ResponseEntity.badRequest().body("Gramms cannot be less or equal to zero");
        }
        if (kalories <= 0) {
            return ResponseEntity.badRequest().body("Kalories cannot be less or equal to zero");
        }

        request.setId(id + 1);

        mealService.create(request);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/sleep")
    public ResponseEntity<String> postSleep(@RequestBody NewSleep request) {
        Integer id = 0;
        var dummy = sleepService.readAll();
        if (dummy.size() > 0){
            id = dummy.get(dummy.size() - 1).getId();
        }

        Integer second = request.getSeconds();

        if (second <= 0) {
            return ResponseEntity.badRequest().body("Seconds cannot be less then zero");
        }
        request.setId(id + 1);
        sleepService.create(request);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<String> getStats(@RequestBody GetStatsUser requset) {
        Integer id = requset.id;
        Integer spendKalo = 0;
        Integer getKalo = 0;
        Integer activitySeconds = 0;
        Integer sleepSeconds = 0;

        for (var activity : activityService.readAll()) {
            if (Objects.equals(id, activity.getUser_id())) {
                spendKalo += activity.getKalories();
                activitySeconds += activity.getSeconds();
            }
        }

        for (var meal : mealService.readAll()) {
            if (id.equals(meal.getUser_id())) {
                getKalo += meal.getKalories();
            }
        }

        for (var sleep : sleepService.readAll()) {
            if (id.equals(sleep.getUser_id())) {
                sleepSeconds += sleep.getSeconds();
            }
        }
        String response = "spend kalories = " + spendKalo + ", get kalories = " + getKalo +
                ", activity time = " + activitySeconds + " seconds, sleep time = " + sleepSeconds + " seconds";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
