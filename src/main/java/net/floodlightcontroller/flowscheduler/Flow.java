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

	private SrcDstIPTuple ipAddresses;
	private TransportPort srcPort;
	private TransportPort dstPort;
	
	public Flow(SrcDstIPTuple ipAddresses, TransportPort srcPort, TransportPort dstPort){
		this.srcPort = srcPort;
		this.dstPort = dstPort;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("srcIp: ");
		sb.append(ipAddresses.getSrcIp().toString());
		sb.append("\tdstIp: ");
		sb.append(ipAddresses.getDstIp().toString());
		sb.append("\tsrcPort: ");
		sb.append(srcPort.getPort());
		sb.append("\tdstPort: ");
		sb.append(dstPort.getPort());
		return sb.toString();
	}
	
	public IPv4Address getSrcIp(){
		return ipAddresses.getSrcIp();
	}
	
	public IPv4Address getDstIp(){
		return ipAddresses.getDstIp();
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
		result = prime * result + ((ipAddresses.getSrcIp() == null) ? 0 : ipAddresses.getSrcIp().hashCode());
		result = prime * result + ((ipAddresses.getDstIp() == null) ? 0 : ipAddresses.getDstIp().hashCode());
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
		if (ipAddresses.getSrcIp() == null) {  
			if (other.ipAddresses.getSrcIp()  != null)
				return false;
		} else if (!ipAddresses.getSrcIp().equals(other.ipAddresses.getSrcIp()))
			return false;
		if (ipAddresses.getDstIp() == null) {  
			if (other.ipAddresses.getDstIp() != null)
				return false;
		} else if (!ipAddresses.getDstIp().equals(other.ipAddresses.getDstIp()))
			return false;
		if (srcPort.getPort() != other.srcPort.getPort())
			return false;
		if (dstPort.getPort() != other.dstPort.getPort())
			return false;
		return true;
	}
	
}
