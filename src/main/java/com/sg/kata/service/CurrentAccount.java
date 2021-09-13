package com.sg.kata.service;

import com.sg.kata.exception.InsufficientBalanceException;
import com.sg.kata.exception.SgBusinessException;
import com.sg.kata.model.History;
import com.sg.kata.model.Holder;
import com.sg.kata.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the classic operations of a bank account with the transaction recording function.
 * @author GABSI Firas
 */
public class CurrentAccount extends Account {

    private Logger logger = LoggerFactory.getLogger(CurrentAccount.class);

    /** History of actions performed on an account. */
    private History operations;

    /** Construction of a current account with a zero balance.
     * @param holder the holder of account
     */
    public CurrentAccount(Holder holder) {
        this(holder, 0);
    }

    /** Construction of a current account with an initial amount.
     * @param holder the holder of account
     * @param initialDeposit the initial amount
    */
    public CurrentAccount(Holder holder, double initialDeposit) {
        super(holder, initialDeposit);
        operations = new History();
        if (initialDeposit > 0) {
            operations.enregistrer(Operation.DEPOSIT, initialDeposit);
        }
    }

    /** Credit the account with the amount (expressed in euros)
     *  The operation will be saved.
     *  @param amount amount to be deposited into the euro account
     */
    public void deposit(double amount) throws InsufficientBalanceException {
        makeOperation(Operation.DEPOSIT, amount);
        operations.enregistrer(Operation.DEPOSIT, amount);
    }

    /** Debit the account for the amount (expressed in euros).
     *  The operation is saved.
     *  @param amount amount withdrawn from the euro account
     * */
    public void withdrawal(double amount) throws InsufficientBalanceException {
        makeOperation(Operation.WITHDRAWAL, amount);
        operations.enregistrer(Operation.WITHDRAWAL, -amount);
    }

    /**
     * Get the history of all operations carried out on an account
     */
    public void getOperationsHistory() throws SgBusinessException {
        logger.info("----------------------------------------");
        logger.info("Holder : " + this.getHolder().toString());
        logger.info("History of operations : ");

        for (int i = 0; i < this.operations.getNbValeurs(); i++) {
            logger.info(operations.getOperation(i));
        }

        logger.info("----------------------------------------");
        logger.info("-- Account balance : " + getSolde());
        logger.info("----------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", opérations=" + this.operations;
    }

}
