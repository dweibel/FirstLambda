package dirk;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import dirk.model.Greeting;
import dirk.model.GreetingBuilder;

public class GreetingService implements RequestHandler<Map<String, Object>, Object> {

	GreetingBuilder builder = new GreetingBuilder();

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		Greeting greet = builder.buildGreeting(input);
		context.getLogger().log("input: " + greet);
		return null;
	}

	// private void sqs() {
	// AWSCredentials credentials = null;
	// try {
	// credentials = new ProfileCredentialsProvider().getCredentials();
	// } catch (Exception e) {
	// throw new AmazonClientException("Cannot load the credentials from the
	// credential profiles file. "
	// + "Please make sure that your credentials file is at the correct "
	// + "location (~/.aws/credentials), and is in valid format.", e);
	// }
	//
	// AmazonSQS sqs = new AmazonSQSClient(credentials);
	// Region usWest2 = Region.getRegion(Regions.US_WEST_2);
	// sqs.setRegion(usWest2);
	//
	// }
}
