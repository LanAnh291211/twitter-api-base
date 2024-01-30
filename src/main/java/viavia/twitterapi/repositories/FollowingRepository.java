package viavia.twitterapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import viavia.twitterapi.entities.Following;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Following.FollowingId> {
}