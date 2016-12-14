package net.floodlightcontroller.forwarding;


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
    
	private String srcIp;
	private String dstIp;
	
	public IPTuple(String srcIp, String dstIp){
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
	
	public String getSrcIp(){
		return srcIp;
	}
	
	public String getDstIp(){
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
