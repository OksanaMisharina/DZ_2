package ru.mail.DZ_2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;


public class Main {
    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new MyModule());
        injector.getInstance(Application.class).waitForInput();
    }
}
