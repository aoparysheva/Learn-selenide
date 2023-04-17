package org.example;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CekRuTest {
        public String URL= "https://1s.cek.ru/";
        public String warningTextId = "phoneMobileWarningMainPage";

        @Test
        public void bottomFeedbackPositive() {

                open(URL);

                element(byId("inputClientPhoneMainPage")).shouldHave(Condition.value(""));
                element(byId(warningTextId)).shouldHave(Condition.cssClass("visually-hidden"));

                element(byId("inputClientNameMainPage")).setValue("Александр");
                element(byId("inputClientNameMainPage")).shouldHave(Condition.value("Александр"));

                element(byId("inputClientPhoneMainPage")).setValue("8314291317");
                element(byId("inputClientPhoneMainPage")).shouldHave(Condition.value("+7(831) 429-13-17"));

                element(byId(warningTextId)).shouldHave(Condition.cssClass("visually-hidden"));

//                element(byId("sendRequestButtonMainPage")).click();

        }
        @Test
        public void bottomFeedbackPhoneNegative() {

                open(URL);

                element(byId(warningTextId)).shouldHave(Condition.cssClass("visually-hidden"));
                element(byId(warningTextId)).shouldHave(Condition.text("Некорректный номер"));
                element(byId("inputClientPhoneMainPage")).shouldHave(Condition.value(""));

                // Отправка формы с пустым телефоном

                element(byId("sendRequestButtonMainPage")).click();

                element(byId(warningTextId)).shouldNotHave(Condition.cssClass("visually-hidden"));

                //Ввод букв в форму телефона невозможен

                element(byId("inputClientPhoneMainPage")).setValue("Fghjhjl");
                element(byId("inputClientPhoneMainPage")).shouldHave(Condition.value(""));

                // Ввод номера телефона с недостающими цифрами

                element(byId("inputClientPhoneMainPage")).setValue("83142913");
                element(byId(warningTextId)).shouldHave(Condition.cssClass("visually-hidden"));
                element(byId("inputClientPhoneMainPage")).shouldHave(Condition.value("+7(831) 429-13"));

                element(byId("sendRequestButtonMainPage")).click();

                element(byId(warningTextId)).shouldNotHave(Condition.cssClass("visually-hidden"));

        }


}

