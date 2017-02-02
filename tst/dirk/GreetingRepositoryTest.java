package dirk;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GreetingRepositoryTest {

	private static SNSEvent input;

	@BeforeClass
	public static void createInput() throws IOException {
		input = TestUtils.parse("sns-event.json", SNSEvent.class);

	}

	private Context createContext() {
		TestContext ctx = new TestContext();

		// TODO: customize your context here if needed.
		ctx.setFunctionName("Your Function Name");

		return ctx;
	}

	@Test
	public void testgreetingRepository() {
		GreetingRepository handler = new GreetingRepository();
		Context ctx = createContext();

		Object output = handler.handleRequest(input, ctx);

		// TODO: validate output here if needed.
		if (output != null) {
			System.out.println(output.toString());
		}
	}
}
