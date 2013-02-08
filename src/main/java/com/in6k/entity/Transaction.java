package com.in6k.entity;

public class Transaction {
    int id;
    private Account debetAccount;
    private Account creditAccount;
    double sum;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getDebetAccount() {
        return debetAccount;
    }

    public void setDebetAccount(Account debetAccount) {
        this.debetAccount = debetAccount;
    }

    public Account getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Account creditAccount) {
        this.creditAccount = creditAccount;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
