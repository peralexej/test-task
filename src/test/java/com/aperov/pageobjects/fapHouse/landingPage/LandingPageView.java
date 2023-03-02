package com.aperov.pageobjects.fapHouse.landingPage;

import static com.codeborne.selenide.Selenide.$x;

public class LandingPageView extends LandingPageContainer {

    public void setInputValueByName(String inputName, String value) {
        $x("//input[@name='" + inputName + "']").setValue(value);
    }

}
