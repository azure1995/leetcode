import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    Map<Integer, User> users;
    int timeStamp;

    public class User {
        int id;
        Map<Integer, Integer> followeesLastPostTime;
        List<Post> posts;
        PriorityQueue<Post> feed;

        User(int id) {
            this.id = id;
            this.followeesLastPostTime = new HashMap<>();
            this.followeesLastPostTime.put(id, -1);
            this.posts = new ArrayList<>();
            this.feed = new PriorityQueue<>(new Comparator<Post>() {
                public int compare(Post p1, Post p2) {
                    return p1.time > p2.time ? 1 : -1;
                }
            });
        }

        public void post(int val) {
            this.posts.add(new Post(val));
        }

        public void addFollowee(int followeeId) {
            if (!followeesLastPostTime.containsKey(followeeId)) {
                followeesLastPostTime.put(followeeId, -1);
            }
        }

        public void removeFollowee(int followeeId) {
            if (followeeId == id) {
                return;
            }
            followeesLastPostTime.remove(followeeId);
            feed.clear();
            for (Integer followee : followeesLastPostTime.keySet()) {
                followeesLastPostTime.put(followee, -1);
            }
        }
    }

    public class Post {
        int val;
        int time;

        Post(int val) {
            this.val = val;
            this.time = timeStamp++;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            return Collections.EMPTY_LIST;
        }
        User user = users.get(userId);
        int oldestPost = -1;
        for (Integer followee : user.followeesLastPostTime.keySet()) {
            if (!users.containsKey(followee)) {
                continue;
            }
            int lt = user.followeesLastPostTime.get(followee);
            List<Post> followeePosts = users.get(followee).posts;
            if (!followeePosts.isEmpty()) {
                int index = followeePosts.size() - 1;
                while (index >= 0) {
                    int t = followeePosts.get(index).time;
                    if (t > Math.max(lt, oldestPost)) {
                        user.feed.add(followeePosts.get(index--));
                        if (user.feed.size() > 10) {
                            oldestPost=Math.max(oldestPost, user.feed.remove().time); 
                        }
                    } else {
                        break;
                    }
                }
                user.followeesLastPostTime.put(followee, followeePosts.get(followeePosts.size() - 1).time);
            }
        }
        PriorityQueue<Post> copy = new PriorityQueue<>(user.feed);
        List<Integer> feed = new LinkedList<>();
        while (!copy.isEmpty()) {
            feed.add(0, copy.remove().val);
        }
        return feed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }
        users.get(followerId).addFollowee(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).removeFollowee(followeeId);
        }
    }
}