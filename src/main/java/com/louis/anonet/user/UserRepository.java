package com.louis.anonet.user;

import com.louis.anonet.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;
import java.time.Instant;

public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByAlias(String alias);
    List<User> findByLastActiveAfter(Instant since);
}
