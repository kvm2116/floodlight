/**
 * 
 */
package net.floodlightcontroller.forwarding;

import java.io.IOException;
import java.util.Map;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author kunalmahajan
 *
 */
public class ForwardingGroupsAssignmentResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(ForwardingGroupsAssignmentResource.class);
	
	/**
	 * Takes a Forwarding Groups Assignment string in JSON format and parses it into
	 * our database schema then pushes it to the database.
	 * @param fmJson The Forwarding Groups Assignment string in JSON format.
	 * @return A string status message
	 */
	@Post
	public String store(String json) {
		log.warn("Received string : " + json);
		return null;
	}

}
