package com.aperov.pageobjects.fapHouse.signupPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignUpPageView extends SignUpPageContainer {

    public void chooseAccountType(String accountType) {
        $x("(//div[@id='field-element-accountType']//div[contains(.,'" + accountType + "')])[1]")
                .shouldBe(Condition.appear).click();
    }

    public void setInputValueByName(String inputName, String value) {
        $(By.name(inputName)).setValue(value);
    }

    public void pressEnterOnInput(String inputName) {
        $(By.name(inputName)).pressEnter().pressEnter();
    }

    public void uploadFileByFieldName(String name) {
        $x("//input[@name='" + name + "']").uploadFile(new File("src/test/resources/pics/document.jpg"));
    }

    public void checkAllBoxesOnFinishPage(int numberOfCheckboxesExpected) {
        for (int i = 1; i < numberOfCheckboxesExpected; i++) {
            $("#form-field-checkbox" + i).scrollTo().click();
        }
    }
}
