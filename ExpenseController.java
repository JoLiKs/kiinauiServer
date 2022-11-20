package com.example.serverforunrealapp.controllers;

import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.repos.UserRepo;
import com.example.serverforunrealapp.servises.ExpService;
import com.example.serverforunrealapp.servises.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {


    private final ExpenseRepo expenseRepo;
    private final ExpService expService;

    public ExpenseController(ExpenseRepo expenseRepo, ExpService expService) {
        this.expenseRepo = expenseRepo;
        this.expService = expService;
    }

    @PostMapping("/add")
    public boolean add(@RequestParam double sum, @RequestParam long time,
                       @RequestParam int day, @RequestParam int month,
                       @RequestParam int year){
        UserModel userModel = new UserModel();
        userModel.setName("Test1");
        userModel.setLogin("Login");
        userModel.setPassword("Pass");
        return expService.add(sum, time, day, month, year, userModel);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int mory){
        return expService.expDel(mory);
    }
    @PostMapping("/edit")
    public String edit(@RequestParam double sum, @RequestParam int mory) {
        return expService.edit(sum, mory);
    }
    @PostMapping("/getSum")
    public double getSum(@RequestParam int mory) {
        return expService.getSum(mory);
    }
}