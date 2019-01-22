/**
 * 
 */
package test.challenge.illumio;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.challenge.illumino.Firewall;

/**
 * @author Noopur Joshi
 *
 */
class FirewallTest {
	static Firewall firewall;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		firewall = new Firewall("test.csv");
	}

	@Test
    public void acceptPacketsTest() throws IOException {
		Assert.assertTrue(firewall.accept_packet("inbound", "tcp", 80, "192.168.1.2"));
        Assert.assertTrue(firewall.accept_packet("outbound", "tcp", 10233, "192.168.10.11"));
        Assert.assertTrue(firewall.accept_packet("inbound", "udp", 53, "192.168.1.11"));
        Assert.assertTrue(firewall.accept_packet("outbound", "udp", 1005, "52.12.48.92"));
    }

    @Test
    public void unacceptablePacketsTest() throws IOException {
    	Assert.assertFalse(firewall.accept_packet("inbound", "tcp", 80, "192.168.0.3"));
        Assert.assertFalse(firewall.accept_packet("outbound", "tcp", 81, "192.168.1.2"));
        Assert.assertFalse(firewall.accept_packet("inbound", "udp", 53, "192.168.1.0"));
        Assert.assertFalse(firewall.accept_packet("outbound", "udp", 999, "52.12.49.92"));
    }

}
