package viavia.twitterapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import viavia.twitterapi.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {
//    @Query("""
//            SELECT ut
//            FROM Tweet ut
//
//            WHERE ut.userId IN (
//                SELECT f.id.followingUserId
//                FROM Following f
//                WHERE f.id.userId = :userId
//            ) OR ut.userId = :userId
//            ORDER BY ut.tweetDate DESC
//            """)
//    Page<Tweet> findByUserIdWithFollowing(@Param("userId") int userId, Pageable pageable);
}