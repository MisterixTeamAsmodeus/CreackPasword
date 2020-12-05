package com.company;

import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        String pass = "LoLs";
        ArrayList<HackThread> hackThreads = new ArrayList<>();
        HackThread.DoneInterface doneInterface = isSuccessful -> {
            if (isSuccessful){
                for (HackThread hackThread : hackThreads) {
                    hackThread.disable();
                }
            }
        };
        hackThreads.add(new HackThread(pass, 3, new String(SymbolPassword.APP_CASE_SYMBOL) + new String(SymbolPassword.LOW_CASE_SYMBOL), doneInterface));
        hackThreads.add(new HackThread(pass, 4, new String(SymbolPassword.APP_CASE_SYMBOL) + new String(SymbolPassword.LOW_CASE_SYMBOL), doneInterface));
        hackThreads.add(new HackThread(pass, 5, new String(SymbolPassword.APP_CASE_SYMBOL) + new String(SymbolPassword.LOW_CASE_SYMBOL), doneInterface));
        for (HackThread hackThread : hackThreads) {
            hackThread.start();
        }
    }
}

