package dirk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GreetingServiceTest {

	private static Map<String, Object> input;

	@BeforeClass
	public static void createInput() throws IOException {
		// TODO: set up your sample input object here.
		input = new HashMap<String, Object>();
		input.put("greeting", "Hello");
		input.put("name", "World");
	}

	private Context createContext() {
		TestContext ctx = new TestContext();

		// TODO: customize your context here if needed.
		ctx.setFunctionName("Your Function Name");

		return ctx;
	}

	@Test
	public void testGreetingService() {
		GreetingService handler = new GreetingService();
		Context ctx = createContext();

		Object output = handler.handleRequest(input, ctx);

		// TODO: validate output here if needed.
		if (output != null) {
			System.out.println(output.toString());
		}
	}
}
