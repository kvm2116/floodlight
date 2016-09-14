package net.floodlightcontroller.statistics;

/*
 * Collect the number of bytes for each flow
 * 
 * Author: Kunal Mahajan (mkunal@cs.columbia.edu)
 */

import java.util.Date;

import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;
import org.projectfloodlight.openflow.types.TableId;
import org.projectfloodlight.openflow.types.U64;

import net.floodlightcontroller.flowscheduler.Flow;

public class FlowCount {
	private DatapathId id;
	private OFPort pt;
	private TableId tableId;
	private int priority;
	private U64 byteSent;			// number of bytes sent within last time interval
	private Date time;
	private U64 byteCount;			// total number of bytes sent from start of time
	private Flow flow;
	
	private FlowCount() {}
	private FlowCount(DatapathId d, OFPort p, TableId tableId, U64 byteSent, U64 byteCount, Flow flow) {
		id = d;
		pt = p;
		this.tableId = tableId;
		this.byteCount = byteCount;
		time = new Date();
		this.byteCount = byteCount;
		this.flow = flow;
		
	}
	
	public static FlowCount of(DatapathId d, OFPort p, TableId tableId, U64 byteSent, U64 byteCount, Flow flow) {
		if (d == null) {
			throw new IllegalArgumentException("Datapath ID cannot be null");
		}
		if (p == null) {
			throw new IllegalArgumentException("Port cannot be null");
		}
		if (tableId.getValue() != 100 || tableId.getValue() != 200) {
			throw new IllegalArgumentException("tableId has to be either 100 or 200");
		}
		if (flow.getSrcIp() == null){
			throw new IllegalArgumentException("Source IP address cannot be null");
		}
		if (flow.getDstIp() == null){
			throw new IllegalArgumentException("Destination IP address cannot be null");
		}
		if(flow.getSrcPort() == null){
			throw new IllegalArgumentException("Source port cannot be null");
		} else if (flow.getSrcPort().getPort() < 0 || flow.getSrcPort().getPort() > 65535){
				throw new IllegalArgumentException("Source port number should be between 0 and 65535");
		}
		if(flow.getDstPort() == null){
			throw new IllegalArgumentException("Destination port cannot be null");
		} else if (flow.getDstPort().getPort() < 0 || flow.getDstPort().getPort() > 65535){
				throw new IllegalArgumentException("Destination port number should be between 0 and 65535");
		}
		return new FlowCount(d, p, tableId, byteSent, byteCount, flow);
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
	
	public Flow getFlow(){
		return flow;
	}
	
	public long getUpdateTime() {
		return time.getTime();
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((flow.getSrcIp() == null) ? 0 : flow.getSrcIp().hashCode());
		result = prime * result + ((flow.getDstIp() == null) ? 0 : flow.getDstIp().hashCode());
		result = prime * result + ((flow.getSrcPort() == null) ? 0 : flow.getSrcPort().hashCode());
		result = prime * result + ((flow.getDstPort() == null) ? 0 : flow.getDstPort().hashCode());
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
		if (flow == null) {  
			if (other.flow != null)
				return false;
		} else if (!flow.equals(other.flow))
			return false;
		return true;
	}
}