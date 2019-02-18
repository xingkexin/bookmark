package org.xkx.bookmark.service;

import java.util.List;

import org.xkx.bookmark.domain.Bookmark;

public interface BookmarkService {

	public List<Bookmark> findByUserIdAndTreeLevel(Long userId, Integer treeLevel);

}
