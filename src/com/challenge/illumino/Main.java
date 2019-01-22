package com.challenge.illumino;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Firewall firewall = new Firewall("test.csv");
        System.out.println(firewall.accept_packet("inbound", "tcp", 80, "192.168.1.2"));
        System.out.println(firewall.accept_packet("outbound", "tcp", 10233, "192.168.10.11"));
        System.out.println(firewall.accept_packet("inbound", "udp", 53, "192.168.1.11"));
        System.out.println(firewall.accept_packet("outbound", "udp", 1005, "52.12.48.92"));
        System.out.println(firewall.accept_packet("inbound", "tcp", 80, "192.168.0.3"));
        System.out.println(firewall.accept_packet("outbound", "tcp", 81, "192.168.1.2"));
        System.out.println(firewall.accept_packet("inbound", "udp", 53, "192.168.1.0"));
        System.out.println(firewall.accept_packet("outbound", "udp", 999, "52.12.49.92"));
	}
}
