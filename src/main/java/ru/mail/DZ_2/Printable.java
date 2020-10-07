package ru.mail.DZ_2;

import java.io.IOException;
import java.util.logging.Logger;

public interface Printable {
    void print(int N, String str, Logger logger) throws IOException;
}
