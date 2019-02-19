package org.xkx.bookmark.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.xkx.bookmark.domain.Bookmark;
import org.xkx.bookmark.service.BookmarkService;

@RestController
public class IndexWeb {
	
	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping(value = {"/", "/bookmark"})
	public ModelAndView index() {
		Map<String, Object> model = new HashMap<>();
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		model.put("bookmarkList", bookmarkList);
		return new ModelAndView("bookmark", model);
	}

	@RequestMapping("/bookmark/edit")
	public ModelAndView toBookmarkEdit() {
		Map<String, Object> model = new HashMap<>();
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		model.put("bookmarkList", bookmarkList);
		return new ModelAndView("bookmark_edit", model);
	}

	@RequestMapping("getBookmarkByTreeview")
	public List<Map<String, Object>> getBookmarkByTreeview() {
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		return genChildByTreeview(bookmarkList);
	}
	
	private List<Map<String, Object>> genChildByTreeview(List<Bookmark> bookmarkList) {
		List<Map<String, Object>> list = new ArrayList<>();
		for(Bookmark mark : bookmarkList) {
			Map<String, Object> model = new HashMap<>();
			model.put("text", mark.getName());
			if(mark.getChildList().size() > 0) {
				model.put("tags", new String[] {mark.getChildList().size() + ""});
				model.put("nodes", genChildByTreeview(mark.getChildList()));
			}else {
				model.put("href", mark.getUrl());
			}
			list.add(model);
		}
		return list;
	}

	@RequestMapping("getBookmarkByZtree")
	public List<Map<String, Object>> getBookmarkByZtree() {
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		return genChildByZtree(bookmarkList);
	}
	
	private List<Map<String, Object>> genChildByZtree(List<Bookmark> bookmarkList) {
		List<Map<String, Object>> list = new ArrayList<>();
		for(Bookmark mark : bookmarkList) {
			Map<String, Object> model = new HashMap<>();
			model.put("id", mark.getId());
			model.put("pId", mark.getParentId());
			model.put("name", mark.getName());
			if(mark.getChildList().size() > 0) {
				model.put("children", genChildByZtree(mark.getChildList()));
			}
			list.add(model);
		}
		return list;
	}
}
