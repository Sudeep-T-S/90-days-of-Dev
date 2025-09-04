import java.util.*;

class Twitter {

    private static int timeStamp = 0;

    private static class Tweet {

        int time;
        int id;
        
        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {

        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(++timeStamp, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (following.containsKey(userId)) 
            users.addAll(following.get(userId));

        for (int user : users) {
            if (!tweets.containsKey(user)) 
                continue;

            List<Tweet> userTweets = tweets.get(user);
            int n = userTweets.size();
            
            for (int i = n - 1; i >= Math.max(0, n - 10); i--) {
                Tweet t = userTweets.get(i);
                minHeap.offer(t);
                
                if (minHeap.size() > 10) 
                    minHeap.poll();
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!minHeap.isEmpty()) 
            res.add(0, minHeap.poll().id); 

        return res;
    }

    public void follow(int followerId, int followeeId) {
        
        if (followerId == followeeId) 
            return;

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        
        if (following.containsKey(followerId)) 
            following.get(followerId).remove(followeeId);
    }
}
