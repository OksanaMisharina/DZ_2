package ru.mail.DZ_2;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.*;

import static java.lang.Thread.*;

public class Application {

    @Inject
    @NotNull
    Logger logger;

    private final @NotNull
    Printable printer1;

    private final @NotNull
    Printable printer2;

    @Inject
    public Application(@NotNull @Named("console") Printable printer1, @NotNull @Named("file") Printable printer2) {
        this.printer1 = printer1;
        this.printer2 = printer2;
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            System.out.println("Enter the type of logging:");
            System.out.println("1 - console");
            System.out.println("2 - file");
            System.out.println("3 - console and file");

            int type = scanner.nextInt();
            String str = scanner.nextLine();
            int N = 0;

            while (true) {

                str = scanner.nextLine();

                if ((type == 1) | (type == 3)) {

                    N++;
                    printer1.print(N, str, logger);
                }
                if ((type == 2) | (type == 3)) {

                    Thread.sleep(1);

                    N++;

                    System.out.println("Enter a tag");
                    String tag = scanner.nextLine();

                    str = "<" + tag + ">" + str + "</" + tag + ">";

                    printer2.print(N, str, logger);
                }
            }

        } catch (IllegalStateException | NoSuchElementException e) {
        } catch (IOException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
