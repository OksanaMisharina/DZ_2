package ru.mail.DZ_2;

import java.util.logging.*;

public class PrintToConsole implements Printable {

    @Override
    public void print(int N, String str, Logger logger) {

        logger.setUseParentHandlers(true);

        logger.log(Level.INFO, N + " " + str);
    }
}
