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
}
