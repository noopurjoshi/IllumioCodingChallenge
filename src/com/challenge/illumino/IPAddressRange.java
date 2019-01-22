package com.challenge.illumino;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Noopur Joshi
 *
 */
class IPAddressRange extends Rule{
    private long start, end;

    public IPAddressRange(String ipAddress) throws UnknownHostException {
        if(ipAddress.contains("-")){
            String[] ipAddresses = ipAddress.split("-");
            start = convertToLong(ipAddresses[0]);
            end = convertToLong(ipAddresses[1]);
        } else{
            start = end = convertToLong(ipAddress);
        }
    }

    /**
     * @param ipAddress
     * @return long
     * @throws UnknownHostException
     */
    // referenced from https://stackoverflow.com/questions/4256438/calculate-whether-an-ip-address-is-in-a-specified-range-in-java
    private long convertToLong(String ipAddress) throws UnknownHostException {
        InetAddress ip_address = InetAddress.getByName(ipAddress);
        byte[] octets = ip_address.getAddress();
        long ipLong = 0;
        for (byte octet : octets) {
            ipLong <<= 8;
            ipLong |= octet & 0xff;
        }
        return ipLong;
    }
    
    /**
     * @param ipAddress
     * @return boolean
     * @throws UnknownHostException
     */
    boolean validateRange(String ipAddress) throws UnknownHostException {
        long ip = convertToLong(ipAddress);
        return ip>=start && ip<=end;
    }
}
