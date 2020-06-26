package top.tinn.Over200.Problem_355;

import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.*;

public class Twitter {

   private Map<Integer, Tweet> twitter;
   private Map<Integer, Set<Integer>> followings;
   private static int timestamp = 0;
   private static PriorityQueue<Tweet> maxHeap;

    /** Initialize your data structure here. */
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b.timestamp - a.timestamp));
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        }else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0){
            for (Integer followingId : followingList){
                Tweet tweet = twitter.get(followingId);
                if (tweet != null){
                    maxHeap.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if (head.next != null){
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        }else {
            followings.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            return;
        }
        // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
        followingList.remove(followeeId);
    }

    /**
     * 单链表
     */
    private class Tweet{
        private int id;
        private int timestamp;
        private Tweet next;
        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    @Test
    public void test(){
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);

    }
}
