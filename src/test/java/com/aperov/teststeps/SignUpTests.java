package com.aperov.teststeps;

import com.aperov.pageobjects.fapHouse.landingPage.LandingPageView;
import com.aperov.pageobjects.fapHouse.signupPage.SignUpPageView;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.aperov.utils.Utils.getRandomString;
import static org.testng.Assert.assertTrue;

/**
 * Copyright (c) 2023.
 * Test steps
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public class SignUpTests extends BaseTest {

    @Test()
    public void test() {
        String email = getRandomString(7) + "@mail.ru";
        Selenide.open("/");
        LandingPageView landingPageView = new LandingPageView();
        landingPageView.setInputValueByName("username", getRandomString(20));
        landingPageView.setInputValueByName("email", email);
        landingPageView.setInputValueByName("password", "dsdAAwd@3");
        landingPageView.submitButton.shouldBe(Condition.enabled).click();
        SignUpPageView signUpPage = new SignUpPageView();
        signUpPage.pageTitle.shouldHave(Condition.text("Complete registration on FapHouse"));
        signUpPage.chooseAccountType("Business");
        signUpPage.setInputValueByName("producerName", getRandomString(5));
        signUpPage.setInputValueByName("contactFirstname", getRandomString(5));
        signUpPage.setInputValueByName("contactLastname", getRandomString(5));
        signUpPage.setInputValueByName("directorFirstname", getRandomString(5));
        signUpPage.setInputValueByName("directorLastname", getRandomString(5));
        signUpPage.setInputValueByName("companyName", "OOO" + getRandomString(5));
        signUpPage.setInputValueByName("registrationNumber", getRandomString(10));
        signUpPage.setInputValueByName("addressCountryCode", "Estonia");
        signUpPage.pressEnterOnInput("addressCountryCode");
        signUpPage.setInputValueByName("addressCity", "Maardu");
        signUpPage.setInputValueByName("addressRegion", "Harju");
        signUpPage.setInputValueByName("addressPostCode", "74111");
        signUpPage.setInputValueByName("addressStreet", "Orumetsa 51");
        signUpPage.setInputValueByName("custodianOfRecordsAddress", "74111 Maardu, Harju, Eesti, Orumetsa 51");
        signUpPage.nextBtn.shouldBe(Condition.enabled).click();
        signUpPage.agreementCheckBox.shouldBe(Condition.visible);
        assertTrue(signUpPage.agreementStep.toString().contains("item active") && signUpPage.agreementStep.toString().contains("2\nAgreement"));
        signUpPage.agreementCheckBox.click();
        signUpPage.nextBtnStep2.click();
        signUpPage.nextBtnStep2.shouldBe(Condition.disappear);
        assertTrue(signUpPage.verificationStep.toString().contains("item active") && signUpPage.verificationStep.toString().contains("3\nVerification"));
        signUpPage.uploadFileByFieldName("passport");
        signUpPage.uploadFileByFieldName("commercialRegisterExtract");
        signUpPage.uploadFileByFieldName("certificateOfIncorporation");
        signUpPage.finishBtn.click();
        signUpPage.h1.shouldHave(Condition.text("Please carefully read the following terms and provide " +
                "required info to keep your content on FapHouse.com"));
        signUpPage.checkAllBoxesOnFinishPage(8);
        signUpPage.setInputValueByName("fullLegalName", getRandomString(8));
        signUpPage.setInputValueByName("jobTitle", getRandomString(8));
        signUpPage.setInputValueByName("companyLegalName", getRandomString(8));
        signUpPage.submit.click();
        signUpPage.pageTitle.shouldHave(Condition.text("Complete registration on FapHouse"));
        signUpPage.emailLabel.shouldHave(Condition.text(email));
    }

}