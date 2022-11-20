package com.example.serverforunrealapp.repos;

import com.example.serverforunrealapp.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface ExpenseRepo extends JpaRepository<ExpenseModel, Long> {

    String deleteExpenseModelById(long id);
    String deleteByMonth(int month);
    String deleteByYear(int year);
    ExpenseModel findExpenseModelByMonth(int month);
    ExpenseModel findExpenseModelByYear(int year);
    @Modifying
    @Transactional
    @Query(value = "update ExpenseModel e set e.sum = ?1 where e.month = ?2")
    int editSumByMonth(double sum, int month);
    @Modifying
    @Transactional
    @Query(value = "update ExpenseModel e set e.sum = ?1 where e.year = ?2")
    int editSumByYear(double sum, int year);

}
