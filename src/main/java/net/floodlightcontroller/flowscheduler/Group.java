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
	
	private Set<Flow> flows;
	private U64 bwConsumed;			// group bandwidth consumed
	
	public Group(){
		flows = new HashSet<Flow>();
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
