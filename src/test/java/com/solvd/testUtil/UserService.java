package com.solvd.testUtil;

import com.solvd.domain.User;
import com.solvd.domain.UserAccount;
import com.zebrunner.carina.utils.R;

public class UserService {

    public static User getUser() {
        User user = new User();
        user.setName(R.TESTDATA.get("FIRST_NAME"));
        user.setLastName(R.TESTDATA.get("LAST_NAME"));
        user.setZipCode(R.TESTDATA.get("ZIP_CODE"));
        return user;
    }

    public static User getIncorrectUser() {
        User user = new User();
        user.setName("");
        user.setLastName(R.TESTDATA.get("LAST_NAME"));
        user.setZipCode(R.TESTDATA.get("ZIP_CODE"));
        return user;
    }

    public static UserAccount getDefaultUser() {
        return new UserAccount(
                R.TESTDATA.get("CORRECT_USERNAME"),
                R.TESTDATA.get("CORRECT_PASSWORD")
        );
    }

    public static UserAccount getIncorrectCredentialsUser() {
        return new UserAccount(
                R.TESTDATA.get("INCORRECT_USERNAME"),
                R.TESTDATA.get("CORRECT_PASSWORD")
        );
    }

    public static UserAccount getLockedOutUser() {
        return new UserAccount(
                R.TESTDATA.get("LOCKED_OUT_USERNAME"),
                R.TESTDATA.get("CORRECT_PASSWORD")
        );
    }

    public static String getWrongInputError() {
        return R.TESTDATA.get("ERROR_MESSAGE_WRONG_INPUT");
    }

    public static String getLockedOutError() {
        return R.TESTDATA.get("ERROR_MESSAGE_LOCKED_OUT");
    }
}