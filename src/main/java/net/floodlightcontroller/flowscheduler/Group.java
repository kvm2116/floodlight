/**
 * 
 */
package net.floodlightcontroller.flowscheduler;

import java.util.HashSet;
import java.util.Set;

import org.projectfloodlight.openflow.types.U64;

/**
 * @author kunalmahajan
 * mkunal@cs.columbia.edu
 */
public class Group {
	
	private int id;					// group id
	private Set<Flow> flows;		// set of flows in the group
	private U64 bwConsumed;			// group bandwidth consumed
	
	public Group(int id){
		this.id = id;
		flows = new HashSet<Flow>();
	}
	
	public int getGroupId(){
		return id;
	}
	
	public void addFlow(Flow flow){
		flows.add(flow);
	}
	
	public Set<Flow> getAllFlow(){
		return flows;
	}
	
	private void calculateGroupBwConsumed(){
		U64 bwValue = null;
		// TODO
		bwConsumed = bwValue;
	}
	
	public U64 getBandwidthConsumed(){
		return bwConsumed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
