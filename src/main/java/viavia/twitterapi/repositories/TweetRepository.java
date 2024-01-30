package viavia.twitterapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import viavia.twitterapi.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {
}