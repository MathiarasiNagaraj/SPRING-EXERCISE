package com.example.demo;

public interface UserServiceInterface {
public int findUser(int id);
public void createUser(User user);
public int checkBalance(int id);
public int doMoneyTransfer(int creditID,int debitID,int amount);
}
