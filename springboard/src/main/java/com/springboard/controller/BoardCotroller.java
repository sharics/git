package com.springboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboard.domain.Board;
import com.springboard.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardCotroller {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value={"/","/list"}, method=RequestMethod.GET)
	public String boardList(Model model) {
		List<Board> boardList = boardService.boardList();
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
}
