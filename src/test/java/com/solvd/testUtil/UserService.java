package com.solvd.testUtil;

import com.solvd.domain.User;
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

}