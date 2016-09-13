/**
 * 
 */
package net.floodlightcontroller.flowscheduler;

import org.projectfloodlight.openflow.types.IPv4Address;
import org.projectfloodlight.openflow.types.TransportPort;

/**
 * @author kunalmahajan
 * mkunal@cs.columbia.edu
 */
public class Flow {

	public IPv4Address srcIp;
	public IPv4Address dstIp;
	public TransportPort srcPort;
	public TransportPort dstPort;
	
	public Flow(IPv4Address srcIp, IPv4Address dstIp, TransportPort srcPort, TransportPort dstPort){
		this.srcIp = srcIp;
		this.dstIp = dstIp;
		this.srcPort = srcPort;
		this.dstPort = dstPort;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("srcIp: ");
		sb.append(srcIp.toString());
		sb.append("\tdstIp: ");
		sb.append(dstIp.toString());
		sb.append("\tsrcPort: ");
		sb.append(srcPort.getPort());
		sb.append("\tdstPort: ");
		sb.append(dstPort.getPort());
		return sb.toString();
	}
}
