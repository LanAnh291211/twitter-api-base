package viavia.twitterapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import viavia.twitterapi.entities.UserTweetView;

@Repository
public interface UserTweetViewRepository extends JpaRepository<UserTweetView, Integer> {
    @Query("""
            SELECT utv
            FROM UserTweetView utv
            WHERE utv.userId IN (
                SELECT f.id.followingUserId
                FROM Following f
                WHERE f.id.userId = :userId
            ) OR utv.userId = :userId
            ORDER BY utv.tweetDate DESC
            """)
    Page<UserTweetView> findPersonalAndFollowingTweet(
            @Param("userId") int userId,
            Pageable pageable
    );

    @Query("""
            SELECT utv
            FROM UserTweetView utv
            WHERE utv.userId = :userId
            ORDER BY utv.tweetDate DESC
            """)
    Page<UserTweetView> findTweetByUserId(
            @Param("userId") int userId,
            Pageable pageable
    );

    @Query("""
            SELECT utv
            FROM UserTweetView utv
            WHERE (COALESCE(:query, null) IS NULL OR LOWER(utv.tweetText) LIKE LOWER(:#{'%'+ #query + '%'}))
            ORDER BY utv.tweetDate DESC
            """)
    Page<UserTweetView> searchTweet(
            @Param("query") String query,
            Pageable pageable
    );
}