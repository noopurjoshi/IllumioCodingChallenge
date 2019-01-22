package com.challenge.illumino;

import java.io.IOException;

/**
 * @author Noopur Joshi
 *
 */
public class Firewall {
	TreeNode tree;

    public Firewall(String filePath) throws IOException {
        tree = new TreeNode();
        tree.constructTree(filePath);
    }

    /**
     * @param direction
     * @param protocol
     * @param port
     * @param ipAddress
     * @return boolean
     * @throws IOException
     */
    public boolean accept_packet(String direction, String protocol, int port, String ipAddress) throws IOException {
        return tree.validateRule(direction, protocol, port, ipAddress);
    }
}
