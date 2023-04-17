package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class AvitoRuTest {
    private String URL = "https://www.avito.ru/";

    @BeforeEach
    public void OpenSite(){
        open(URL);
    }
    @Test
    public void Tovary_dlya_detey_i_igrushki(){
    //Выбор локации
       // $x("//*[@class='desktop-nev1ty']").("Нижний Новгород");

    //Выбор категории
        element(byAttribute("alt", "Товары для детей")).click();
        element(byAttribute("data-marker", "category[1000275]/link")).click();

    //Выбор товара из списка
        $x("//*[@id='i2931825139']").click();
        sleep(5000);
    //Выбрать: купить с доставкой
        element(byAttribute("data-marker", "delivery-item-button-main")).click();




    }
}

