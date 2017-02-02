package dirk.model;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingBuilder {

	// TODO build a generic model builder using reflection
	public Greeting buildGreeting(Map<String, Object> map) {
		Greeting greeting = new Greeting();
		greeting.name = map.get("name").toString();
		greeting.greeting = map.get("greeting").toString();
		return greeting;
	}

	public Greeting buildGreeting(String json) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Greeting greeting = new Greeting();
		JsonNode jNode = mapper.readTree(json);
		greeting.setName(jNode.get("name").asText());
		greeting.setGreeting(jNode.get("greeting").asText());
		return greeting;
	}

}
