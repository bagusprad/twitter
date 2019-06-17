import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "C7p2nLpP2S5j7vNXWf9URYBb5";
    private final static String CONSUMER_KEY_SECRET = "FVB571yNtk1TIb8HRVVNqC21FqKE4ntFHuWr8LpNbU65zukAFY";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hello gaes");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "A0qOo1BijVo4ECmrman5MbL0EQmZmUsYvE5SN73k95UTT";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140549003093790720-Yn2mfJqp0yZOcqIkmsuN5YBR93cuVi";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}