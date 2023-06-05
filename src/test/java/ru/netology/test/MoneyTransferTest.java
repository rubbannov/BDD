package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashBoardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

public class MoneyTransferTest {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    @BeforeEach
    void setUp() {
        loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = getVerificationCode();
        dashBoardPage = verificationPage.validVerify(verificationCode);

    }

    @Test
    void testTransaction() {
        var firstCardBalance = dashBoardPage.getCardBalance(0);
        var secondCardBalance = dashBoardPage.getCardBalance(1);
        var amount = 5000;
        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;
        var transactionPage = dashBoardPage.fromFirstToSecondCard();
        var transactionInfo = DataHelper.getFirstCard();
        dashBoardPage = transactionPage.inputTransaction(transactionInfo, String.valueOf(amount));

        var actualBalanceFirstCard = dashBoardPage.getCardBalance(0);
        var actualBalanceSecondCard = dashBoardPage.getCardBalance(1);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }
}
