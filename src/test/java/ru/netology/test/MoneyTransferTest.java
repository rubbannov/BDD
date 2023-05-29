package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashBoardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransactionPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
        @Test
    void testTransaction () {
            open("http://localhost:9999");
            var loginPage = new LoginPage();
            var authInfo = DataHelper.getOtherAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCode();
            var dashboardPage = verificationPage.validVerify(verificationCode);
            var transactionPage = dashboardPage.fromFirstToSecondCard();
            var transactionInfo = DataHelper.getFirstCard();
            transactionPage.inputTransaction(transactionInfo);

        }
}
