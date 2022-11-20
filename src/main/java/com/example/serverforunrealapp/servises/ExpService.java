package com.example.serverforunrealapp.servises;

import com.example.serverforunrealapp.models.ExpenseModel;
import com.example.serverforunrealapp.models.UserModel;
import com.example.serverforunrealapp.repos.ExpenseRepo;
import com.example.serverforunrealapp.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpService {
    private final ExpenseRepo expenseRepo;

    public ExpService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public String expDel(int mory){
        if (mory > 1000) return expenseRepo.deleteByYear(mory);
        return expenseRepo.deleteByMonth(mory);
    }

    public boolean add(double sum, long time, int day, int month, int year, UserModel userModel) {
        ExpenseModel expenseModel = new ExpenseModel();
        expenseModel.setSum(sum);
        expenseModel.setTime(time);
        expenseModel.setDay(day);
        expenseModel.setMonth(month);
        expenseModel.setYear(year);
        expenseRepo.save(expenseModel);
        return true;
    }
    public String edit(double sum, int mory) {
        if (mory > 1000) return String.valueOf(expenseRepo.editSumByYear(sum, mory));
        return String.valueOf(expenseRepo.editSumByMonth(sum, mory));
    }

    public double getSum(int mory) {
        if (mory > 1000) return expenseRepo.findExpenseModelByYear(mory).getSum();
        return expenseRepo.findExpenseModelByMonth(mory).getSum();
    }
}
