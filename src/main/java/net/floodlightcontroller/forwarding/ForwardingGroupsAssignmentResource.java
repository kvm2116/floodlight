/**
 * 
 */
package net.floodlightcontroller.forwarding;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.projectfloodlight.openflow.protocol.match.MatchFields;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import jdk.nashorn.internal.parser.JSONParser;



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
		try {
			jsonToStorageEntry(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Turns a JSON formatted Forwarding string into a storage entry
	 * Expects a string in JSON along the lines of:
	 *        {
	 *        	"(u'10.10.1.1', u'10.10.1.2')": {"0": 29, "1": 29}, 
	 *        	"(u'10.10.1.1', u'10.10.1.3')": {"0": 53, "1": 53},
	 *        	"(u'10.10.1.2', u'10.10.1.1')": {"0": 43, "1": 43}, 
	 *        	"(u'10.10.1.3', u'10.10.1.1')": {"0": 43, "1": 43}
	 *        }
	 * @param fmJson The JSON formatted Forwarding string
	 * @return The map of the storage entry
	 * @throws IOException If there was an error parsing the JSON
	 */
	public static Map<String, Object> jsonToStorageEntry(String fmJson) throws IOException {
		String new_string = fmJson.replace("\\", "");
		String json_string = new_string.substring(1, new_string.length() - 1);
		JSONObject jo = null;
		log.warn(json_string);
		try {
			jo = new JSONObject(json_string);
			for(String s : JSONObject.getNames(jo)){
				JSONObject jo2 = jo.getJSONObject(s);
				String ipTupleStr = s.toString().replaceAll("'", "");
				String ipTuple = ipTupleStr.substring(1, ipTupleStr.length()-1);
				String[] ips = ipTuple.split(",");
				String src_ip = ips[0];
				String dst_ip = ips[1];
				log.warn(src_ip + "    "  + dst_ip);
				for(String s1 : JSONObject.getNames(jo2)){
					int group = Integer.parseInt(s1);
					int port = jo2.getInt(s1);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}
}
