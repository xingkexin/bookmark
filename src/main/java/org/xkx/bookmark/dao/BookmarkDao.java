package org.xkx.bookmark.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xkx.bookmark.domain.Bookmark;

@Repository
public interface BookmarkDao extends JpaRepository<Bookmark, Long> {

	public List<Bookmark> findByUserIdAndTreeLevel(Long userId, Integer treeLevel);
}
