package com.sg.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    public static final double EPSILON = 1e-6;

    protected Account account1, account2;
    protected Holder holder;

    @Before
    public void setUp() {
        holder = new Holder("GABSI", "Firas");

        account1 = new Account(holder, 1000);
        account2 = new Account(holder);
    }

    @Test
    public void accountC1InitializationTest() {
        Assert.assertEquals(account1.getHolder(), this.holder);
        Assert.assertEquals(1000, account1.getSolde(), EPSILON);
    }

    @Test
    public void accountC2InitializationTest() {
        Assert.assertEquals(account2.getHolder(), this.holder);
        Assert.assertEquals(0, account2.getSolde(), EPSILON);
    }

    @Test
    public void depositAccountTest() throws Exception {
        account1.makeOperation(Operation.DEPOSIT, 100);
        Assert.assertEquals(1100, account1.getSolde(), EPSILON);
    }

    @Test
    public void withdrawalAccountTest() throws Exception {
        account1.makeOperation(Operation.WITHDRAWAL, 100);
        Assert.assertEquals(900, account1.getSolde(), EPSILON);
        account1.makeOperation(Operation.WITHDRAWAL, 250);
        Assert.assertEquals(650, account1.getSolde(), EPSILON);
    }

    @Test
    public void oerationsAccountTest() throws Exception {
        account1.makeOperation(Operation.WITHDRAWAL, 200);
        Assert.assertEquals(800, account1.getSolde(), EPSILON);
        account1.makeOperation(Operation.DEPOSIT, 600);
        Assert.assertEquals(1400, account1.getSolde(), EPSILON);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void withdrawalNotAutoriseTest() throws Exception {
        account2.makeOperation(Operation.WITHDRAWAL, 1000000);
    }

}