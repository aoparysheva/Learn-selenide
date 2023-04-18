package org.example;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
public class UnsplashTest {
    @Test
    public void unsplashTest(){
        open("https://unsplash.com/login");

//Ввод логина в поле
        $x("//div[@class='form-group']//input[@id='user_email']")
                .setValue("test@mail.com")
                .shouldBe(Condition.value("test@mail.com"));

//Ввод пароля в поле
        $x("//div[@class='form-group']//input[@id='user_password']")
                .setValue("123456")
                .shouldBe(Condition.value("123456"));

//Проверка отклика кнопки "Login"
        $x("//div[@class='form-group']//input[@name='commit']")
                .shouldBe(Condition.visible)
                .click();

//Проверка уведомления о некорректном пароле/логине
        $x("//div[@class='col-xs-10 col-sm-6 center-block flash__message']")
                .shouldBe(Condition.exactText("Invalid email or password."));

    }
}
