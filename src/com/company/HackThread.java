package com.company;

import java.util.Date;

public class HackThread implements Runnable {

    private final String passwords;
    private final int length;

    public HackThread(String password, int length) {
        this.passwords = password;
        this.length = length;
    }

    @Override
    public void run() {
        final boolean[] isRun = {true};
        SymbolPassword password = new SymbolPassword(() -> isRun[0] = false);
        password.setPosCharPass(new String(SymbolPassword.NUMBER));
        password.setLength(length);
        long time = new Date().getTime();
        while (isRun[0]) {
            if (password.toString().equals(passwords)) {
                System.out.println("Password " + password.toString());
                break;
            }
            password.next();
        }
        System.out.println("Password length = " + length);
        System.out.println("Time = " + String.valueOf(new Date().getTime() - time));
    }
}
