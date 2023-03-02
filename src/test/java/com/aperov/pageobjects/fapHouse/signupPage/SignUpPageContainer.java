package com.aperov.pageobjects.fapHouse.signupPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class SignUpPageContainer {
    public final SelenideElement nextBtn = $("#wizard-business-form-submit-btn");
    public final SelenideElement nextBtnStep2 = $x("//button//span[text()='Next']");
    public final SelenideElement finishBtn = $x("//button//span[text()='Finish registration']");
    public final SelenideElement pageTitle = $("#wizard-page-title");
    public final SelenideElement agreementCheckBox = $("#field-element-contractSigned");
    public final SelenideElement agreementStep = $x("//div[text()='Agreement']");
    public final SelenideElement verificationStep = $x("//div[text()='Verification']");
    public final SelenideElement h1 = $x("//h1");
    public final SelenideElement submit = $("#affidavit-modal__ok");
    public final SelenideElement emailLabel = $x("//div[text()='To complete registration, check your email ']//strong");


}

