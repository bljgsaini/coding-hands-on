package designProblems.designTwitterLeetcode355;

import java.time.LocalDateTime;
import java.util.*;

//355. Design Twitter
class Twitter {

    Map<Integer, Deque<Post>> tweets;
    Map<Integer, Set<Integer>> followees;
    Map<Integer, Set<Integer>> followers;

    public Twitter() {
        tweets = new HashMap();
        followees = new HashMap();
        followers = new HashMap();
    }

    public void postTweet(int userId, int tweetId) {
        Deque<Post> deque = tweets.getOrDefault(userId, new ArrayDeque());
        deque.addFirst(new Post(tweetId, LocalDateTime.now()));
        tweets.put(userId, deque);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followeesSet = followees.getOrDefault(userId, new HashSet());
        followeesSet.add(userId);

        Iterator<Integer> itr = followeesSet.iterator();

        PriorityQueue<Post> newsFeed = new PriorityQueue<Post>(10, (a, b)-> a.date.compareTo(b.date) );

        while(itr.hasNext()){
            int followeeId = itr.next();
            Deque<Post> followeeTweets = tweets.get(followeeId);
            if(followeeTweets == null ) continue;

            Iterator<Post> dequeItr = followeeTweets.iterator();
            int i =0;
            while(dequeItr.hasNext() && i<10){
                Post post = dequeItr.next();
                if(newsFeed.size() < 10){
                    newsFeed.add(post);
                }else{
                    if(newsFeed.peek().date.compareTo(post.date)  < 0){
                        newsFeed.poll();
                        newsFeed.add(post);
                    }
                }
                i++;
            }

        }

        followeesSet.remove(userId);

        List<Integer> recentPost = new ArrayList();
        while(!newsFeed.isEmpty()){
            recentPost.add(newsFeed.poll().tweetId);
        }

        Collections.reverse(recentPost);
        return recentPost;

    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followeesSet = followees.getOrDefault(followerId, new HashSet() );
        followeesSet.add(followeeId);
        followees.put(followerId, followeesSet);

        Set<Integer> followerSet = followers.getOrDefault(followeeId, new HashSet() );
        followerSet.add(followerId);
        followers.put(followeeId, followerSet);

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeesSet = followees.getOrDefault(followerId, new HashSet() );
        followeesSet.remove(followeeId);
        followees.put(followerId, followeesSet);

        Set<Integer> followerSet = followers.getOrDefault(followeeId, new HashSet() );
        followerSet.remove(followerId);
        followers.put(followeeId, followerSet);

    }
}


class Post{
    int tweetId;
    LocalDateTime date;
    Post(int tweetId, LocalDateTime date){
        this.tweetId = tweetId;
        this.date = date;
    }
}
