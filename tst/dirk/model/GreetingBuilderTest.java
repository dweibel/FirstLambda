package dirk.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class GreetingBuilderTest {

	private GreetingBuilder builder = new GreetingBuilder();
	private static String GREET_JSON = "{ \"greeting\": \"Hello\", \"name\": \"World\" }";

	@Test
	public final void testBuildGreetingMapOfStringString() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("greeting", "Hello");
		map.put("name", "World");

		assert (assertGreeting(builder.buildGreeting(map)));
	}

	@Test
	public final void testBuildGreetingString() throws JsonProcessingException, IOException {
		assert (assertGreeting(builder.buildGreeting(GREET_JSON)));
	}

	private boolean assertGreeting(Greeting greet) {
		if (greet.getGreeting().equals("Hello") && greet.getName().equals("World")) {
			return greet.toString().equals(GREET_JSON);
		} else {
			return false;
		}
	}

}
