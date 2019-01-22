# Illumio Coding Challenge
## Problem Statement
* Given a set of firewall rules, a network packet will be accepted by the firewall if and only if the direction, protocol, port, and IP address match at least one of the input rules. If a rule contains a port range, it will match all packets whose port falls within the range. If a rule contains an IP address range, it will match all packets whose IP address falls within the range.

## Design
* Created modular classes for each component such as - Direction, Protocol, PortRange and IPAddressRange.
* I decided to create a tree structure to save the initial set of rules.
* Used HashMap for better lookup and insertion.

## Testing
* Used Junit test cases to test the code.

## Future Additions/ Improvements
* In case I had more time I would have used a Cache to improve the performance of the system.
* I could also add logging into the system using Spring AOP.

## Team Preferences:
1.Policy<br/>
2.Platform
