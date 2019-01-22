package com.challenge.illumino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author Noopur Joshi
 *
 */
public class TreeNode {
	private Rule root;
	
	public TreeNode(){
        this.root = new Rule();
    }
	
	/**
	 * @param filePath
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void constructTree(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String node;
        while((node = reader.readLine()) != null){
            String[] nodes = node.split(",");
            addRules(nodes[0], nodes[1], nodes[2], nodes[3]);
        }
    }
	
	/**
	 * @param direction
	 * @param protocol
	 * @param port
	 * @param ipAddress
	 * @throws IOException
	 */
	private void addRules(String direction, String protocol, String port, String ipAddress) throws IOException {
		Rule directionRules = addMapping(direction, root, new Direction(direction));
		Rule protocolRules = addMapping(protocol, directionRules, new Protocol(protocol));
		Rule portRules = addMapping(port, protocolRules, new PortRange(port));
		addMapping(ipAddress, portRules, new IPAddressRange(ipAddress));
    }

    /**
     * @param value
     * @param rule
     * @param newRule
     * @return com.challenge.illumio.Rule
     */
    private Rule addMapping(String value, Rule rule, Rule newRule){
    	Rule rule2 = rule.getChildNodes().getOrDefault(value, newRule);
        rule.getChildNodes().put(value, rule2);
        return rule2;
    }
    
    /**
     * @param direction
     * @param protocol
     * @param port
     * @param ipAddress
     * @return boolean
     * @throws UnknownHostException
     */
    public boolean validateRule(String direction, String protocol, int port, String ipAddress) throws UnknownHostException {
        Rule rules = root.getRule(direction);
        if(rules==null)
            return false;
        rules = rules.getRule(protocol);
        if(rules==null)
            return false;
        rules = rules.getRule(String.valueOf(port));
        if(rules==null)
            return false;
        return rules.getRule(ipAddress)!=null;
    }
}
