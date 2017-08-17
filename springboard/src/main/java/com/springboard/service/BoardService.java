package com.springboard.service;

import java.util.List;

import com.springboard.domain.Board;

public interface BoardService {
	public List<Board> boardList();
	public List<Board> boardList(int pageNum);
	public void insertBoard(Board b);
	public void deleteBoard(int bno);
	public void updateBoard(Board b);
	public Board detailBoard(Board b);
}
