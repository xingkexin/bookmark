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

	@RequestMapping("/")
	public ModelAndView index() {
		Map<String, Object> model = new HashMap<>();
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		model.put("bookmarkList", bookmarkList);
		return new ModelAndView("bookmark", model);
	}

	@RequestMapping("/demo")
	public ModelAndView demo() {
		Map<String, Object> model = new HashMap<>();
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		model.put("bookmarkList", bookmarkList);
		return new ModelAndView("tree-demo", model);
	}

	@RequestMapping("getBookmarkTree")
	public Map<String, Object> getBookmarkTree() {
		Map<String, Object> model = new HashMap<>();
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		model.put("text", "根节点");
		model.put("nodes", genChild(bookmarkList));
		return model;
	}

	@RequestMapping("getBookmarkTree2")
	public List<Map<String, Object>> getBookmarkTree2() {
		Long userId = 1L;
		Integer treeLevel = 1;
		List<Bookmark> bookmarkList = bookmarkService.findByUserIdAndTreeLevel(userId, treeLevel);
		return genChild(bookmarkList);
	}
	
	private List<Map<String, Object>> genChild(List<Bookmark> bookmarkList) {
		List<Map<String, Object>> list = new ArrayList<>();
		for(Bookmark mark : bookmarkList) {
			Map<String, Object> model = new HashMap<>();
			model.put("text", mark.getName());
			if(mark.getChildList().size() > 0) {
				model.put("tags", new String[] {mark.getChildList().size() + ""});
				model.put("nodes", genChild(mark.getChildList()));
			}else {
				model.put("href", mark.getUrl());
			}
			list.add(model);
		}
		return list;
	}
}
