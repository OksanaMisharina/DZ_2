package ru.mail.DZ_2;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {

        //bind(Printable.class).to(PrintToConsole.class);
        bind(Printable.class).annotatedWith(Names.named("console")).to(PrintToConsole.class);
        bind(Printable.class).annotatedWith(Names.named("file")).to(PrintToFile.class);
        bind(Printable.class).annotatedWith(Names.named("all")).to(PrintToFile.class);
        //bind(Printable.class).toInstance(new PrintToConsole());
    }
}
