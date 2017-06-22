package com.tpg.interview.ip;

import java.util.Scanner;

public class IPValidationRegex {
    private static final String FROM_0_TO_255 = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])";
    private static final String IP_REXP = String.format("%s.%s.%s.%s", FROM_0_TO_255, FROM_0_TO_255, FROM_0_TO_255, FROM_0_TO_255);

    public static boolean isValidIpAddress(String addr) {
        if (addr == null || "".equals(addr) || addr.length() < 7 || addr.length() > 15) {
            return false;
        }

        return addr.matches(IP_REXP);
    }

    /**
     * pls see junit test {@IPValidationRegexTest}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new IPValidationRegex().getClass().getResourceAsStream("ips.txt"));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // ONLY print valid ip address
            if (IPValidationRegex.isValidIpAddress(line)) {
                sb.append(line).append("\r\n");
            }
        }
        scanner.close();
        
        System.out.println(sb.toString());
    }
}
