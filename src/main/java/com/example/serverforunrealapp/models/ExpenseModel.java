package com.example.serverforunrealapp.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expense")
public class ExpenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "sum")
    private double sum;

    @Column(name = "time")
    long time;

    @Column(name = "day")
    private int day;

    @Column(name = "month")
    private int month;

    @Column(name = "year")
    private int year;

    @ManyToOne
    UserModel userModel;
    
        public ExpenseModel(double sum, long time, int day, int month, int year, UserModel userModel) {
        this.sum = sum;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.userModel = userModel;
    }
}
