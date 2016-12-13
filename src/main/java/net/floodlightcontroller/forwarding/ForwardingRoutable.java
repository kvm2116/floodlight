/**
 * 
 */
package net.floodlightcontroller.forwarding;

import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import net.floodlightcontroller.restserver.RestletRoutable;

/**
 * @author kunalmahajan
 * PhD student, Columbia University
 * (mkunal@cs.columbia.edu)
 */
public class ForwardingRoutable implements RestletRoutable {

	@Override
	public Restlet getRestlet(Context context) {
		Router router = new Router(context);
        router.attach("/json", ForwardingGroupsAssignmentResource.class);
        router.attach("/json/store", ForwardingGroupsAssignmentResource.class);
        router.attach("/clear/{switch}/json", ClearForwardingGroupsResource.class);
        router.attach("/list/{switch}/json", ListForwardingGroupsResource.class);
        return router;
	}

	@Override
	public String basePath() {
		return "/wm/forwarding";
	}

}
