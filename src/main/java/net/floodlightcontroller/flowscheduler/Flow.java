/**
 * 
 */
package net.floodlightcontroller.flowscheduler;

import org.projectfloodlight.openflow.types.IPv4Address;
import org.projectfloodlight.openflow.types.TransportPort;

import net.floodlightcontroller.statistics.FlowCount;

/**
 * @author kunalmahajan
 * mkunal@cs.columbia.edu
 */
public class Flow {

	private IPv4Address srcIp;
	private IPv4Address dstIp;
	private TransportPort srcPort;
	private TransportPort dstPort;
	
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
	
	public IPv4Address getSrcIp(){
		return srcIp;
	}
	
	public IPv4Address getDstIp(){
		return dstIp;
	}
	
	public TransportPort getSrcPort(){
		return srcPort;
	}
	
	public TransportPort getDstPort(){
		return dstPort;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((srcIp == null) ? 0 : srcIp.hashCode());
		result = prime * result + ((dstIp == null) ? 0 : dstIp.hashCode());
		result = prime * result + ((srcPort == null) ? 0 : srcPort.hashCode());
		result = prime * result + ((dstPort == null) ? 0 : dstPort.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flow other = (Flow) obj;
		if (srcIp == null) {  
			if (other.srcIp  != null)
				return false;
		} else if (!srcIp.equals(other.srcIp))
			return false;
		if (dstIp == null) {  
			if (other.dstIp != null)
				return false;
		} else if (!dstIp.equals(other.dstIp))
			return false;
		if (srcPort.getPort() != other.srcPort.getPort())
			return false;
		if (dstPort.getPort() != other.dstPort.getPort())
			return false;
		return true;
	}
	
}
