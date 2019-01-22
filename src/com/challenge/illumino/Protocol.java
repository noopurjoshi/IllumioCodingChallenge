package com.challenge.illumino;

import java.util.Map;

/**
 * @author Noopur Joshi
 *
 */
public class Protocol extends Rule{
	private String protocol;

	public Protocol(String protocol) {
		// TODO Auto-generated constructor stub
		this.protocol = protocol;
	}
	
	/* (non-Javadoc)
	 * @see com.challenge.illumino.Rule#getRule(java.lang.String)
	 */
	public Rule getRule(String port){
        if (childNodes.getOrDefault(port, null) == null) {
            int portNum = Integer.parseInt(port);
            for (Map.Entry<String, Rule> entry : childNodes.entrySet()) {
                PortRange prop = (PortRange) entry.getValue();
                if (prop.validateRange(portNum)) {
                    return prop;
                }
            }
        }
        return childNodes.getOrDefault(port, null);
    }

}
