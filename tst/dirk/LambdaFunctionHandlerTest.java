package dirk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

	private static Map<?, ?> INPUT_HELLO = buildDefaultMap();

	private Context createContext() {
		TestContext ctx = new TestContext();

		// TODO: customize your context here if needed.
		ctx.setFunctionName("First Lambda");

		return ctx;
	}

	private static Map<?, ?> buildDefaultMap() {
		Map<String, Object> result = new HashMap<>();
		result.put("greeting", "Hello");
		result.put("name", "World");
		return result;
	}

	@Test
	public void testLambdaFunctionHandler() {
		LambdaFunctionHandler handler = new LambdaFunctionHandler();
		Context ctx = createContext();

		Object output = handler.handleRequest(INPUT_HELLO, ctx);

		// what do we have here?
		if (output != null) {
			System.out.println(output.toString());
		}

		assertNotNull(output);
		assertTrue("Hello World".equals(output));
	}
}
