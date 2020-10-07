package ru.mail.DZ_2;

import java.io.IOException;
import java.util.logging.*;


public class PrintToFile implements Printable {


    @Override
    public void print(int N, String str, Logger logger) throws IOException {

        logger.setUseParentHandlers(false);

        FileHandler fh = new FileHandler("OutputLog.txt");
        fh.setFormatter(new SimpleFormatter());
        fh.setLevel(Level.INFO);
        logger.addHandler(fh);

        logger.log(Level.INFO, N + " " + str);
    }
}
