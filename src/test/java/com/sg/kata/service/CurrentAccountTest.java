package com.sg.kata.service;

import com.sg.kata.model.Holder;

public class CurrentAccountTest extends AccountTest {

    @Override
    public void setUp() {
        this.holder = new Holder("GABSI", "Firas");
        this.account = new CurrentAccount(this.holder, 1000);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(CurrentAccountTest.class.getName());
    }

}
