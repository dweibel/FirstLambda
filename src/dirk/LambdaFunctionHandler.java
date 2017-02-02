package dirk;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Object, Object> {

	private static String NAME = "name";
	private static String GREETING = "greeting";
	private static String UNDEFINED = "undefined";

	@Override
	public Object handleRequest(Object input, Context context) {
		context.getLogger()
				.log("Input Type: " + input.getClass().getName() + ", Input String: " + input.toString() + '\n');
		String greeting = UNDEFINED;
		String name = UNDEFINED;

		if (input instanceof Map) {
			Map<?, ?> inputMap = (Map<?, ?>) input;
			greeting = inputMap.get(GREETING).toString();
			name = inputMap.get(NAME).toString();
		}

		return greeting + " " + name;
	}

}
