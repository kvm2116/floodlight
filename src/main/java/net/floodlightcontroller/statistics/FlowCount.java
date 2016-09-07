package net.floodlightcontroller.statistics;

/*
 * Collect the number of bytes for each flow
 * 
 * Author: Kunal Mahajan (mkunal@cs.columbia.edu)
 */

import java.util.Date;

import org.projectfloodlight.openflow.protocol.match.Match;
import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;
import org.projectfloodlight.openflow.types.U64;

public class FlowCount {
	private DatapathId id;
	private OFPort pt;
	private int tableId;
	private int priority;
	private int idleTimeout;
	private int hardTimeout;
	private U64 packetCount;
	private U64 byteCount;
	private Date time;
	private U64 packetCountOld;
	private U64 byteCountOld;
	private Match match;

	private FlowCount() {}
	private FlowCount(DatapathId d, OFPort p, int tableId, int priority, int idleTimeout, int hardTimeout, U64 packetCount, U64 byteCount, U64 packetCountOld, U64 byteCountOld, Match match) {
		id = d;
		pt = p;
		this.tableId = tableId;
		this.priority = priority;
		this.idleTimeout = idleTimeout;
		this.hardTimeout = hardTimeout;
		this.packetCount = packetCount;
		this.byteCount = byteCount;
		time = new Date();
		this.packetCountOld = packetCountOld;
		this.byteCountOld = byteCountOld;
		this.match = match;
	}
	
	public static FlowCount of(DatapathId d, OFPort p, int tableId, int priority, int idleTimeout, int hardTimeout, U64 packetCount, U64 byteCount, U64 packetCountOld, U64 byteCountOld, Match match) {
		if (d == null) {
			throw new IllegalArgumentException("Datapath ID cannot be null");
		}
		if (p == null) {
			throw new IllegalArgumentException("Port cannot be null");
		}
		if (tableId != 100 || tableId != 200) {
			throw new IllegalArgumentException("tableId has to be either 100 or 200");
		}
		if (priority < 0) {
			throw new IllegalArgumentException("priority cannot be negative");
		}
		return new FlowCount(d, p, tableId, priority, idleTimeout, hardTimeout, packetCount, byteCount, packetCountOld, byteCountOld, match);
	}
	
	public DatapathId getSwitchId() {
		return id;
	}
	
	public OFPort getSwitchPort() {
		return pt;
	}
	
	public int getTableId() {
		return tableId;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public U64 getByteCount() {
		return byteCount;
	}
	
	protected U64 getPriorByteCount() {
		return byteCountOld;
	}
	
	public long getUpdateTime() {
		return time.getTime();
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pt == null) ? 0 : pt.hashCode());
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
		if (pt == null) {  
			if (other.pt != null)
				return false;
		} else if (!pt.equals(other.pt))
			return false;
		return true;
	}
}