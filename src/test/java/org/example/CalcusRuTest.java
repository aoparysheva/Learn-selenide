package org.example;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CalcusRuTest {
    @BeforeAll
    public static void calcusru(){
        open("https://calcus.ru/kalkulyator-ndfl");
    }


    @Test
    public void checkResult(){
        //Выбор radio-button
        $x("//*[@class='desktop-nev1ty']").selectOptionContainingText("Нижний Новгород");

        //Выбор Суммы до налогообложения
        $x("//*[@name='amount']")
                .setValue("500000");


        $x("//*[@name='tax_type']").selectOptionByValue("3");
        $x("//*[@class='calc-submit']").click();





        sleep(1000);
        $x("//*[contains(@class, 'result-placeholder-fullAmount')]").shouldHave(Condition.text("714 285,71"));
        $x("//*[contains(@class, 'result-placeholder-tax')]").shouldHave(Condition.text("214 285,71"));
    }
    @Test
    public void fullVerificationTest(){
        open("https://calcus.ru/kalkulyator-ndfl");
        // check default all values
        element(byId("operation-2"))
                .shouldHave(Condition.checked);
        $x("//*[@name='amount']")
                .shouldHave(Condition.value(""));
        $x("//*[@name='tax_type']")
                .shouldHave(Condition.value("1"));

        // select the expected value
        element(byText("Известна сумма после налогообложения")).click();
        element(byId("operation-1"))
                .shouldHave(Condition.checked);
        $x("//*[@name='amount']")
                .setValue("500000");
        $x("//*[@name='tax_type']")
                .selectOptionByValue("3");

        // check that result is hidden
        $x("//*[contains(@class, 'result-placeholder-tax')]")
                .shouldNotBe(Condition.visible);
        $x("//*[@class='calc-submit']").click();
        sleep(1000);

        // check that result is shown
        $x("//*[contains(@class, 'result-placeholder-tax')]")
                .shouldBe(Condition.visible);
        $x("//*[contains(@class,'result-placeholder-fullAmount')]")
                .shouldHave(Condition.text("714 285,71"));
        $x("//*[contains(@class,'result-placeholder-tax')]")
                .shouldHave(Condition.text("214 285,71"));
    }
}

