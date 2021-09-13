package com.sg.kata.model;

import com.sg.kata.exception.SgBusinessException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class History {

    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";

    private ArrayList<String> operations;

    // Initialize account history
    public History() {
        operations = new ArrayList<>();
    }

    // Save new operation information in the history
     public void enregistrer(Operation operation, double montant) {
         operations.add(new StringBuffer(new SimpleDateFormat(DATE_FORMAT).format(new Date()))
                 .append(" --> ")
                 .append(operation.name())
                 .append(" -- Montant : ")
                 .append(montant).toString());
     }

     public String getOperation(int operationIndex) throws SgBusinessException {
         if (operationIndex < operations.size()) {
             return operations.get(operationIndex);
         }
         throw new SgBusinessException("Transaction NOT exist !!");
     }

    /** Le nombre d'entiers enregistrés dans l'historique
     * @return le nombre d'entiers dans l'historique
     */
    public int getNbValeurs() {
        return operations.size();
    }

}
