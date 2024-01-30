package viavia.twitterapi.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "following")
public class Following {
    @EmbeddedId
    private FollowingId id;

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FollowingId implements Serializable {
        @Column(name = "user_id")
        private Integer userId;

        @Column(name = "following_user_id")
        private Integer followingUserId;
    }
}
