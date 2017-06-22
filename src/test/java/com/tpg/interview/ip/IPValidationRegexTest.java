package com.tpg.interview.ip;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IPValidationRegexTest {

    @Test
    public void testIPAddress() {
        assertThat(IPValidationRegex.isValidIpAddress(""), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("0.0.0.0"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("1.1.1.1"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("001.001.001.001"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("127.0.0.1"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("125.1.2.254"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("012.023.034.055"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("256.1.1.1"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("0000.1.1.1"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("000.1.1.1"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("0001.234.123.124"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("256.256.256.256"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("266.266.266.266"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("255.255.255.255"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("555.555.555.555"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("666.666.666.666"), is(false));
        assertThat(IPValidationRegex.isValidIpAddress("249.249.249.249"), is(true));
        assertThat(IPValidationRegex.isValidIpAddress("249.249.249.256"), is(false));
    }
}
