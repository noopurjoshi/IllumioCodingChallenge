package com.challenge.illumino;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author Noopur Joshi
 *
 */
public class PortRange extends Rule {
	private int start, end;

    public PortRange(String port){
        if(port.contains("-")){
            String[] portRanges = port.split("-");
            start = Integer.parseInt(portRanges[0]);
            end = Integer.parseInt(portRanges[1]);
        } else{
            start = end = Integer.parseInt(port);
        }
    }

    /* (non-Javadoc)
     * @see com.challenge.illumino.Rule#getRule(java.lang.String)
     */
    public Rule getRule(String portRange) throws UnknownHostException {
        if (childNodes.getOrDefault(portRange, null) == null) {
            for (Map.Entry<String, Rule> entry : childNodes.entrySet()) {
            	IPAddressRange prop = (IPAddressRange) entry.getValue();
                if (prop.validateRange(portRange)) {
                    return prop;
                }
            }
        }
        return childNodes.getOrDefault(portRange, null);
    }
    
    /**
     * @param port
     * @return boolean
     */
    boolean validateRange(int port){
        return port>=start && port<=end;
    }

}
