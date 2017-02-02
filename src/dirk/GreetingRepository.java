package dirk;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.lambda.runtime.events.SNSEvent.SNS;
import com.amazonaws.services.lambda.runtime.events.SNSEvent.SNSRecord;

import dirk.model.Greeting;
import dirk.model.GreetingBuilder;

public class GreetingRepository implements RequestHandler<SNSEvent, Object> {

	List<String> repository = new ArrayList<String>();
	GreetingBuilder greetingBuilder = new GreetingBuilder();

	@Override
	public Object handleRequest(SNSEvent input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("Input record count: " + input.getRecords().size() + '\n');
		for (SNSRecord rec : input.getRecords()) {
			SNS sns = rec.getSNS();
			String msg = sns.getMessage();
			Greeting greet;
			try {
				greet = greetingBuilder.buildGreeting(msg);
				logger.log("  Greeting: " + greet.getGreeting() + ", " + greet.getName());
				repository.add(msg);
			} catch (Exception e) {
				logger.log("Invalid message: " + e.getMessage());
			}
		}
		return null;
	}

}
