package com.example.projectapp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
public class InputValidator {

    // Method to check if the input is a valid URL
    public static boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            return url.getProtocol() != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"));
        } catch (MalformedURLException e) {
            return false;
        }
    }

    // Method to validate if the input is a valid IP address
    public static boolean isValidIPAddress(String ip) {
        String ipPattern =
                "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(ipPattern);
        return pattern.matcher(ip).matches();
    }
}
