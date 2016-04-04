/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmthingy;

/**
 *
 * @author HP USER
 */
public class User {
    private String name;
    private String PIN;
    private int accNum;
    private double checking_balance;
    private double savings_balance;

    public User() {
        name = "Shawn Fernandes";
        PIN = "9612";
        accNum = 500642575;
        checking_balance = 500;
        savings_balance = 5000;
    }

    public User(String PIN, double cbal, double savbal) {
        this.PIN = PIN;
        checking_balance = cbal;
        savings_balance = savbal;
    }
    
    public String getName(){
        return name;
    }
    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
    
    public int getAccNum(){
        return accNum;
    }
    
    public double getChecking() {
        return checking_balance;
    }

    public boolean withdrawChecking(double withdraw) {
        if ((checking_balance - withdraw) <= 0) {
            return false;
        }
        checking_balance -= withdraw;
        return true;
    }

    public void depositChecking(double deposit) {
        checking_balance += deposit;
    }

    public double getSaving() {
        return savings_balance;
    }

    public boolean withdrawSaving(double withdraw) {
        if ((savings_balance - withdraw) <= 0) {
            return false;
        }
        savings_balance -= withdraw;
        return true;
    }

    public void depositSaving(double deposit) {
        savings_balance += deposit;
    }

    public boolean TransferSaving(double withdraw) {
        if ((checking_balance - withdraw) <= 0) {
            return false;
        }
        checking_balance -= withdraw;
        savings_balance += withdraw;
        return true;
    }

    public boolean TransferChecking(double withdraw) {
        if ((savings_balance - withdraw) <= 0) {
            return false;
        }
        savings_balance -= withdraw;
        checking_balance += withdraw;
        return true;
    }

}
