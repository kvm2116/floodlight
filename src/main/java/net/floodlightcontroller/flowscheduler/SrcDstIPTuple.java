/**
 * 
 */
package net.floodlightcontroller.flowscheduler;

import org.projectfloodlight.openflow.types.IPv4Address;

/**
 * @author kunalmahajan
 * mkunal@cs.columbia.edu
 */
public class SrcDstIPTuple {
	
	private IPv4Address srcIp;
	private IPv4Address dstIp;
	
	public SrcDstIPTuple(IPv4Address srcIp, IPv4Address dstIp){
		this.srcIp = srcIp;
		this.dstIp = dstIp;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("srcIp: ");
		sb.append(srcIp.toString());
		sb.append("\tdstIp: ");
		sb.append(dstIp.toString());
		return sb.toString();
	}
	
	public IPv4Address getSrcIp(){
		return srcIp;
	}
	
	public IPv4Address getDstIp(){
		return dstIp;
	}
}
