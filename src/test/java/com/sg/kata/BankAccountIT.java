package com.sg.kata;

import com.sg.kata.exception.InsufficientBalanceException;
import com.sg.kata.exception.SgBusinessException;
import com.sg.kata.model.Holder;
import com.sg.kata.service.Account;
import org.junit.Before;
import org.junit.Test;

public class BankAccountIT {

    private  Holder holder;

    @Before
    public void setUp() {
        holder = new Holder("GABSI", "Firas");
    }

    @Test
    public void bank_Account_Scenaro_1_IT() {

        CurrentAccount compteCourant = new CurrentAccount(holder, 0);
        compteCourant.deposit(1000);
        compteCourant.getOperationsHistory();
    }

    @Test
    public void bank_Account_Scenaro_2_IT() {

        CurrentAccount compteCourant = new CurrentAccount(holder, 100);
        compteCourant.deposit(1000);
        compteCourant.withdrawal(500);
        compteCourant.getOperationsHistory();
    }

}
