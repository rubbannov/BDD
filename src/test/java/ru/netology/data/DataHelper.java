package ru.netology.data;

import lombok.Value;
import org.checkerframework.checker.units.qual.C;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    public static AuthInfo getAuthInfo () {
        return new AuthInfo("vasya" ,"qwerty123");
    }
    public static AuthInfo getOtherAuthInfo () {
        return new AuthInfo("petya", "123qwerty");
    }
    @Value
    public static class VerificationCode {
        private String code;
    }
    public static VerificationCode getVerificationCode () {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String number;
        private String balance;
    }
    public static CardInfo getFirstCard () {
        return new CardInfo("5559000000000001", "10000");
    }
    public static CardInfo getSecondCard () {
        return new CardInfo("5559000000000002", "10000");
    }

}
