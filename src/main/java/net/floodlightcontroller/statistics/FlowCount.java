package net.floodlightcontroller.statistics;

/*
 * Collect the number of bytes for each flow
 * 
 * Author: Kunal Mahajan (mkunal@cs.columbia.edu)
 */

import java.util.Date;

import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.IPv4Address;
import org.projectfloodlight.openflow.types.OFPort;
import org.projectfloodlight.openflow.types.TableId;
import org.projectfloodlight.openflow.types.TransportPort;
import org.projectfloodlight.openflow.types.U64;

public class FlowCount {
	private DatapathId id;
	private OFPort pt;
	private TableId tableId;
	private int priority;
	private U64 byteSent;			// number of bytes sent within last time interval
	private Date time;
	private U64 byteCount;			// total number of bytes sent from start of time
	private IPv4Address srcIp;		// flow source ip address
	private IPv4Address destIp;		// flow destination ip address
	private TransportPort srcPort;			// flow source port number
	private TransportPort destPort;			// flow destination port number
	
	private FlowCount() {}
	private FlowCount(DatapathId d, OFPort p, TableId tableId, U64 byteSent, U64 byteCount, IPv4Address srcIp, IPv4Address destIp, TransportPort srcPort, TransportPort destPort) {
		id = d;
		pt = p;
		this.tableId = tableId;
		this.byteCount = byteCount;
		time = new Date();
		this.byteCount = byteCount;
		this.srcIp = srcIp;
		this.destIp = destIp;
		this.srcPort = srcPort;
		this.destPort = destPort;
		
	}
	
	public static FlowCount of(DatapathId d, OFPort p, TableId tableId, U64 byteSent, U64 byteCount, IPv4Address srcIp, IPv4Address destIp, TransportPort srcPort, TransportPort destPort) {
		if (d == null) {
			throw new IllegalArgumentException("Datapath ID cannot be null");
		}
		if (p == null) {
			throw new IllegalArgumentException("Port cannot be null");
		}
		if (tableId.getValue() != 100 || tableId.getValue() != 200) {
			throw new IllegalArgumentException("tableId has to be either 100 or 200");
		}
		if (srcIp == null){
			throw new IllegalArgumentException("Source IP address cannot be null");
		}
		if (destIp == null){
			throw new IllegalArgumentException("Destination IP address cannot be null");
		}
		if(srcPort == null){
			throw new IllegalArgumentException("Source port cannot be null");
		} else if (srcPort.getPort() < 0 || srcPort.getPort() > 65535){
				throw new IllegalArgumentException("Source port number should be between 0 and 65535");
		}
		if(destPort == null){
			throw new IllegalArgumentException("Destination port cannot be null");
		} else if (destPort.getPort() < 0 || destPort.getPort() > 65535){
				throw new IllegalArgumentException("Destination port number should be between 0 and 65535");
		}
		return new FlowCount(d, p, tableId, byteSent, byteCount, srcIp, destIp, srcPort, destPort);
	}
	
	public DatapathId getSwitchId() {
		return id;
	}
	
	public OFPort getSwitchPort() {
		return pt;
	}
	
	public TableId getTableId() {
		return tableId;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public U64 getByteSent() {
		return byteSent;
	}
	
	public U64 getPriorByteCount() {
		return byteCount;
	}
	
	public IPv4Address getSrcIp(){
		return srcIp;
	}
	
	public IPv4Address getDestIp(){
		return destIp;
	}
	
	public TransportPort getSrcPort(){
		return srcPort;
	}
	
	public TransportPort getDestPort(){
		return destPort;
	}
	
	public long getUpdateTime() {
		return time.getTime();
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((srcIp == null) ? 0 : srcIp.hashCode());
		result = prime * result + ((destIp == null) ? 0 : destIp.hashCode());
		result = prime * result + ((srcPort == null) ? 0 : srcPort.hashCode());
		result = prime * result + ((destPort == null) ? 0 : destPort.hashCode());
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
		FlowCount other = (FlowCount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		// TODO: compare other match fields in this method
		if (srcIp == null) {  
			if (other.srcIp != null)
				return false;
		} else if (!srcIp.equals(other.srcIp))
			return false;
		if (destIp == null) {  
			if (other.destIp != null)
				return false;
		} else if (!srcIp.equals(other.destIp))
			return false;
		if (srcPort != other.srcPort)
			return false;
		if (destPort != other.destPort)
			return false;
		return true;
	}
}