package com.sg.kata.service;

import com.sg.kata.exception.InsufficientBalanceException;
import com.sg.kata.model.Holder;
import com.sg.kata.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Rrepresented a simple bank account held in euros.
 * @author GABSI Firas
 */
public class Account {

    private Logger logger = LoggerFactory.getLogger(Account.class);

    // Solde du compte exprimé en euros.
    private double balance;

    // Holder of account
    private Holder holder;

    /** Initialize an account.
        @param holder holder of the account
    */
    public Account(Holder holder) {
        this(holder, 0);
    }

    /** Initialize an account.
     * @param holder holder of the account
     * @param initialDeposit initial amount of the account
     */
    public Account(Holder holder, double initialDeposit) {
        logger.info(new StringBuffer("Account opening for : ")
                .append(holder.getFirstname())
                .append(" ")
                .append(holder.getLastname().toUpperCase())
                .toString());
        this.holder = holder;
        this.balance = initialDeposit;
    }

    public double getSolde() {
        return balance;
    }

    public Holder getHolder() {
        return holder;
    }

    public void makeOperation(Operation operation, double amount) throws InsufficientBalanceException {
        logger.info("Start of operation : " + operation);
        switch (operation) {
            case DEPOSIT:
                deposit (amount);
                break;
            case WITHDRAWAL:
                withdrawal (amount);
                break;
        }
    }

    /** Credit the account with the amount (expressed in euros).
     * @param amount amount deposited in the euro account
     */
    private void deposit (double amount) {
        this.balance = this.balance + amount;
        logger.info("Deposit made.");
    }

    /**
     *  Debit the account for the amount (expressed in euros).
     *  @param amount amount withdrawn from the euro account
    */
    private void withdrawal (double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            logger.error("Insufficient balance !!");
            throw new InsufficientBalanceException("Your balance is insufficient !!");
        }
        this.balance = this.balance - amount;
        logger.info("Withdrawal made.");
    }

    public String toString() {
        return new StringBuffer("Balance = ")
                .append(this.balance)
                .append(", holder = \"")
                .append(this.holder.toString())
                .append("\"").toString();
    }

}
