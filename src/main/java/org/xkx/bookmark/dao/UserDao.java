package org.xkx.bookmark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xkx.bookmark.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
