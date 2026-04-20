/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package com.anhtester.mail;

import com.anhtester.constants.FrameworkConstants;

import java.util.Arrays;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {

    //Nhớ tạo mật khẩu app (App Password) cho Gmail mới gửi được nhen
    //Nếu dùng mail của Hosting thì bình thường
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "traxxia.qa.reports@gmail.com";
    public static final String PASSWORD = normalizePassword("nalu vgkq afbn umwl");

    public static final String[] TO = normalizeRecipients(
            "durairaj.subramaniyan@piquota.com",
            "lavanya.murugesan@piquota.com","ravikumar.lakshman@piquota.com");
    public static final String SUBJECT = FrameworkConstants.REPORT_TITLE;

    private static String normalizePassword(String rawPassword) {
        return rawPassword.replace(" ", "").trim();
    }

    private static String[] normalizeRecipients(String... recipients) {
        return Arrays.stream(recipients)
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .distinct()
                .toArray(String[]::new);
    }
}