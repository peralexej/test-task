package com.aperov.pageobjects.fapHouse.landingPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class LandingPageContainer {
    public final SelenideElement submitButton = $x("//form[@id='create-account']//button[@type='submit']");

}
