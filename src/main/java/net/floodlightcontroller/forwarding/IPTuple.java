package net.floodlightcontroller.forwarding;

import org.projectfloodlight.openflow.types.IPv4Address;

/**
 * @author kunalmahajan
 * PhD student, Columbia University
 * (mkunal@cs.columbia.edu)
 */


/**
 * A IPTuple 
 * It stores source ip and destination ip address
 */

public class IPTuple {
    
	private IPv4Address srcIp;
	private IPv4Address dstIp;
	
	public IPTuple(IPv4Address srcIp, IPv4Address dstIp){
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (srcIp.hashCode() ^ (dstIp.hashCode()));
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
        IPTuple other = (IPTuple) obj;
        if (!srcIp.equals(other.srcIp))
            return false;
        if (!dstIp.equals(other.dstIp))
            return false;
        return true;
    }
}
