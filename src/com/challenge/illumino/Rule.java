package com.challenge.illumino;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Noopur Joshi
 *
 */
class Rule {
    public Map<String, Rule> childNodes;

    public Rule(){
    	childNodes = new HashMap<>();
    }

    /**
     * @return HashMap
     */
    public Map<String, Rule> getChildNodes(){
        return childNodes;
    }

    /**
     * @param property
     * @return com.challenge.illumio.Rule
     * @throws UnknownHostException
     */
    public Rule getRule(String property)  throws UnknownHostException {
        return childNodes.getOrDefault(property, null);
    }
}
