package com.company;

import java.util.Date;

public class HackThread extends Thread {

    private final String passwords;
    private final int length;
    private final String passwordText;
    private final DoneInterface doneInterface;
    public interface DoneInterface{
        void isDone(boolean isSuccessful);
    }
    private boolean isActive;

    public void disable(){
        isActive=false;
    }

    public HackThread(String password, int length, String passwordText, DoneInterface doneInterface) {
        this.passwords = password;
        this.length = length;
        this.passwordText = passwordText;
        this.doneInterface = doneInterface;
        isActive = true;
    }

    @Override
    public void run() {
        final boolean[] isRun = {true};
        SymbolPassword password = new SymbolPassword(() -> isRun[0] = false);
        password.setPosCharPass(passwordText);
        password.setLength(length);
        long time = new Date().getTime();
        while (isRun[0] && isActive) {
            if (password.toString().equals(passwords)) {
                System.out.println("Password " + password.toString());
                doneInterface.isDone(true);
                break;
            }
            password.next();
        }
        if (isActive){
            doneInterface.isDone(false);
            System.out.println("Password length = " + length);
            System.out.println("Time = " + (new Date().getTime() - time));
        }
    }
}
