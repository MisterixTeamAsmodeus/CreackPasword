package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        final boolean[] isRun = {true};
        SymbolPassword password = new SymbolPassword(() -> isRun[0] = false);
        password.setPosCharPass(new String(SymbolPassword.NUMBER));
        password.setLength(10);
        long time = new Date().getTime();
        while (isRun[0]) {
            System.out.println(password.toString());
            password.next();
        }
        System.out.println(new Date().getTime() - time);
    }
}