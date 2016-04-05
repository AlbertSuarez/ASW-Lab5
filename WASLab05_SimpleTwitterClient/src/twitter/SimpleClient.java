package twitter;

import java.util.Date;

import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.util.function.Consumer;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		final Twitter twitter = new TwitterFactory().getInstance();
		final TwitterStream stream = new TwitterStreamFactory().getInstance();
		
		/* TASCA 4
		Date now = new Date();
		String latestStatus = "I want to increase the Klout score of @cfarre [task #4 completed "+now+"]";
		Status status = twitter.updateStatus(latestStatus);
		System.out.println("Successfully updated the status to: " + status.getText());
		
		*/
		
		
		/* TASCA 5
		Query query = new Query();
		query.setCount(1);
		query.setQuery("from:@fib_was");
		query.setResultType(ResultType.recent);
		
		QueryResult qr = twitter.search(query);
		Status tweet = qr.getTweets().get(0);
		System.out.println(tweet.getText());
		
		twitter.retweetStatus(tweet.getId());
		*/
		
		//TASCA 6
		stream.onStatus(new Consumer<Status> (){

			@Override
			public void accept(Status t) {
				System.out.println(t.getUser().getName() + " (" + t.getUser().getScreenName() + "): "
						+t.getText());
				
			}
			
		});
		
		stream.filter("#Barcelona");
	}
}
