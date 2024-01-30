package viavia.twitterapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viavia.twitterapi.entities.Following;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Following.FollowingId> {
    @Modifying
    @Query("""
             DELETE FROM Following f
             WHERE f.id.userId = :userId AND f.id.followingUserId= :followingUserId
            """
    )
    void deleteFollowingBy(int userId, int followingUserId);

    @Query("""
             SELECT count(f) > 0
             FROM Following f
             WHERE f.id.userId = :userId AND f.id.followingUserId= :followingUserId
            """
    )
    boolean checkIsFollowing(int userId, int followingUserId);
}