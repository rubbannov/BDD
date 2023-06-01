package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
        @Test
    void testTransaction () {
            open("http://localhost:9999");
            var loginPage = new LoginPage();
            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCode();
            var dashboardPage = verificationPage.validVerify(verificationCode);
            var transactionPage = dashboardPage.fromFirstToSecondCard();
            var transactionInfo = DataHelper.getFirstCard();
            transactionPage.inputTransaction(transactionInfo, "5000");
            var expected = 15_000;
            var actual = dashboardPage.getCardBalance(1);
            assertEquals(expected, actual);
        }
}
