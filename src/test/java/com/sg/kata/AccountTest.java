package com.sg.kata;

import com.sg.kata.exception.InsufficientBalanceException;
import com.sg.kata.model.Holder;
import com.sg.kata.model.Operation;
import com.sg.kata.service.Account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {

    public static final double EPSILON = 1e-6;

    protected Account account;
    protected Holder holder;

    @Before
    public void setUp() {
        holder = new Holder("GABSI", "Firas");
        account = new Account(holder, 1000);
    }

    @Test
    public void accountInitializationTest() {
        Assert.assertEquals(account.getHolder(), this.holder);
        Assert.assertEquals(1000, account.getSolde(), EPSILON);
    }

    @Test
    public void depositAccountTest() throws Exception {
        account.makeOperation(Operation.DEPOSIT, 100);
        Assert.assertEquals(1100, account.getSolde(), EPSILON);
    }

    @Test
    public void withdrawalAccountTest() throws Exception {
        account.makeOperation(Operation.WITHDRAWAL, 100);
        Assert.assertEquals(900, account.getSolde(), EPSILON);
        account.makeOperation(Operation.WITHDRAWAL, 250);
        Assert.assertEquals(650, account.getSolde(), EPSILON);
    }

    @Test
    public void oerationsAccountTest() throws Exception {
        account.makeOperation(Operation.WITHDRAWAL, 200);
        Assert.assertEquals(800, account.getSolde(), EPSILON);
        account.makeOperation(Operation.DEPOSIT, 600);
        Assert.assertEquals(1400, account.getSolde(), EPSILON);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void withdrawalNotAutoriseTest() throws Exception {
        account.makeOperation(Operation.WITHDRAWAL, 1000000);
    }

}