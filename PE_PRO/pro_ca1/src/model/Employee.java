/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author vannhat
 */
public class Employee implements Comparable<Employee> {
//    EmpId (Employee ID)
//- Account (Employee Account)
//- WorkStartingDate (Starting date to work for the company)
//- ProductivityScore (Performance from 0.8~1.2)
//- MonthlyIncome (Monthly Income)
//- RewardSalary (Monthly Bonus)
//- Allowance

    
    private String emId;
    private String account;
    private LocalDate workStartingDate;
    private float productivityScore;
    private int monthlyIncome;
    private int rewardSalary;
    private int allowance;

    public Employee(String emId, String account, LocalDate workStartingDate, float productivityScore, int allowance) {
        this.emId = emId;
        this.account = account;
        this.workStartingDate = workStartingDate;
        this.productivityScore = productivityScore;
        this.allowance = allowance;
    }

    public Employee() {
    }

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDate getWorkStartingDate() {
        return workStartingDate;
    }

    public void setWorkStartingDate(LocalDate workStartingDate) {
        this.workStartingDate = workStartingDate;
    }

    public float getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(float productivityScore) {
        this.productivityScore = productivityScore;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getRewardSalary() {
        return rewardSalary;
    }

    public void setRewardSalary(int rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
    
    //- CalMonthlyIncome method (Used to calculate monthly income)
//- CalReward method (Used to calculate monthly salary and bonus)
//The program allows to calculate the employee's monthly payment
//- How to calculate monthly bonus (RewardSalary)
//RewardSalary = ProductivityScore * 3,000,000
//- How to calculate monthly income (MonthlyIncome)
//MonthlyIncome = RewardSalary + Allowance
    public int calReward(){
        this.rewardSalary = (int) (this.productivityScore * 3000000.00);
        return this.rewardSalary;
    }
    
    public int calMonthlyIncome(){
        this.monthlyIncome = this.allowance + calReward();
        return this.monthlyIncome;
    }

    @Override
    public String toString() {
        return "Employee{" + "emId=" + emId + ", account=" + account + ", workStartingDate=" + workStartingDate + ", productivityScore=" + productivityScore + ", monthlyIncome=" + monthlyIncome + ", rewardSalary=" + rewardSalary + ", allowance=" + allowance + '}';
    }
    
    @Override
    public int compareTo(Employee employee){
        return this.calMonthlyIncome() - employee.calMonthlyIncome();
    }

    
}
