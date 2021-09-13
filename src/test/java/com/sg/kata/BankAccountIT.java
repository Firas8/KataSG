package com.sg.kata;

import com.sg.kata.exception.InsufficientBalanceException;
import com.sg.kata.exception.SgBusinessException;
import com.sg.kata.model.Holder;
import com.sg.kata.service.CurrentAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountIT {

    public static final double EPSILON = 1e-6;

    private  Holder holder;

    @Before
    public void setUp() {
        holder = new Holder("GABSI", "Firas");
    }

    @Test
    public void bank_Account_Scenaro_1_IT() throws InsufficientBalanceException, SgBusinessException {

        CurrentAccount compteCourant = new CurrentAccount(holder, 0);

        compteCourant.deposit(1000);
        compteCourant.getOperationsHistory();

        Assert.assertEquals(1000, compteCourant.getSolde(), EPSILON);
    }

    @Test
    public void bank_Account_Scenaro_2_IT() throws InsufficientBalanceException, SgBusinessException {

        CurrentAccount compteCourant = new CurrentAccount(holder, 100);

        compteCourant.deposit(1000);
        compteCourant.withdrawal(500);
        compteCourant.getOperationsHistory();

        Assert.assertEquals(600, compteCourant.getSolde(), EPSILON);
    }

}
