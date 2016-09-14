/**
 * 
 */
package net.floodlightcontroller.flowscheduler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kunalmahajan
 * mkunal@cs.columbia.edu
 */

public class GroupCollection {
	
	private int numGroups;
	private Set<Group> groupSet;
	
	public GroupCollection(int numGroups){
		this.numGroups = numGroups;
		groupSet = new HashSet<Group>();
		initGroups();
	}
	
	private void initGroups(){
		for(int i = 1; i <= numGroups; i++){
			Group group = new Group(i);
			groupSet.add(group);
		}
	}
	
	public Set<Group> getGroupCollection(){
		return groupSet;
	}
}
