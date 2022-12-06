import java.util.ArrayList;

//keeps an ArrayList of tweets of every user. Observer Design pattern.
public class Follower implements Observer 
{
    ArrayList<String> tweets = new ArrayList<String>();
	ArrayList<Long> updatedTimes = new ArrayList<Long>();

    public ArrayList<String> getTweets() 
	{
        return this.tweets;
    }

    public void setTweets(ArrayList<String> tweets) 
	{
        this.tweets = tweets;
    }

    public ArrayList<Long> getUpdatedTimes() 
	{
        return this.updatedTimes;
    }

    public void setUpdatedTimes(ArrayList<Long> updatedTimes) 
	{
        this.updatedTimes = updatedTimes;
    }

    // The update method called from the Subject class adds the recently tweeted message from the User class and appends it to the tweets ArrayList in this class
    @Override
    public void update(Subject subject)
	{
        tweets.add(((User) subject).getTweet());
    }

}