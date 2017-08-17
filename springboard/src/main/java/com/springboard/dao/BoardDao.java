package com.springboard.dao;

import java.util.List;

import com.springboard.domain.Board;

public interface BoardDao {
	public List<Board> boardList();
	public List<Board> boardList(int startRow, int endRow);
	public int boardCount();
	public void insertBoard(Board b);
	public void deleteBoard(int bno);
	public void updateBoard(Board b);
	public Board detailBoard(Board b);
}
