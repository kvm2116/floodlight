package net.floodlightcontroller.forwarding;

import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.restlet.resource.Get;

/**
 * @author kunalmahajan
 *
 */

public class ListForwardingGroupsResource extends ServerResource {
	protected static Logger log = LoggerFactory.getLogger(ListForwardingGroupsResource.class);
    
    @Get("json")
    public String ListStaticFlowEntries() {
        return "test";
    }
}
