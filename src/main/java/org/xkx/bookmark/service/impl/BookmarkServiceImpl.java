package org.xkx.bookmark.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.bookmark.dao.BookmarkDao;
import org.xkx.bookmark.domain.Bookmark;
import org.xkx.bookmark.service.BookmarkService;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService {
	
	@Autowired
	private BookmarkDao bookmarkDao;

	@Override
	public List<Bookmark> findByUserIdAndTreeLevel(Long userId, Integer treeLevel) {
		return bookmarkDao.findByUserIdAndTreeLevel(userId, treeLevel);
	}
	
	@PostConstruct
	public void initData() {
		Bookmark data;
		
		data = new Bookmark();
		data.setId(1L);
		data.setParentId(null);
		data.setName("tomcat");
		data.setUrl(null);
		data.setTreeLevel(1);
		data.setTreeLeaf(false);
		data.setTreeSort(1);
		data.setUserId(1L);
		data.setCreateTime(new Date());
		bookmarkDao.save(data);
		
		data = new Bookmark();
		data.setId(2L);
		data.setParentId(null);
		data.setName("帮助文档");
		data.setUrl(null);
		data.setTreeLevel(1);
		data.setTreeLeaf(false);
		data.setTreeSort(2);
		data.setUserId(1L);
		data.setCreateTime(new Date());
		bookmarkDao.save(data);
		
		data = new Bookmark();
		data.setId(21L);
		data.setParentId(2L);
		data.setName("Spring Boot");
		data.setUrl("https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/");
		data.setTreeLevel(2);
		data.setTreeLeaf(true);
		data.setTreeSort(1);
		data.setUserId(1L);
		data.setCreateTime(new Date());
		bookmarkDao.save(data);
		
		data = new Bookmark();
		data.setId(3L);
		data.setParentId(null);
		data.setName("帮助文档");
		data.setUrl(null);
		data.setTreeLevel(1);
		data.setTreeLeaf(false);
		data.setTreeSort(3);
		data.setUserId(1L);
		data.setCreateTime(new Date());
		bookmarkDao.save(data);
		
		data = new Bookmark();
		data.setId(31L);
		data.setParentId(3L);
		data.setName("Spring Boot");
		data.setUrl("https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/");
		data.setTreeLevel(2);
		data.setTreeLeaf(true);
		data.setTreeSort(1);
		data.setUserId(1L);
		data.setCreateTime(new Date());
		bookmarkDao.save(data);
	}

}
