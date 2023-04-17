package org.example;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    public void userCanFindSelenideAndSeleniumInfo() {
        open("https://google.com");
        element(byName("q")).setValue("selenide");
        element(byValue("Поиск в Google")).click();

        elements("#search .g").first().shouldHave(text("Selenide: лаконичные и стабильные"));

        back();
        element(byName("q")).setValue("selenium");
        element(byValue("Поиск в Google")).click();

        elements("#search .g").first().shouldHave(text("selenium.dev"));
    }

    @Test
    public void userCanFindCypressInfo() {
        open("https://google.com");
        element(byName("q")).setValue("cypress");
        element(byValue("Поиск в Google")).click();

        elements("#search .g").first().shouldHave(text("cypress.io"));
    }
}
