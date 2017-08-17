package com.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.dao.BoardDao;
import com.springboard.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList() {

		return boardDao.boardList();
	}

	@Override
	public List<Board> boardList(int pageNum) {
		
		int currentPage = pageNum;
		
		int startRow = (currentPage -1 ) * PAGE_SIZE +1;
		int endRow= startRow + PAGE_SIZE -1;
		int listCount = boardDao.boardCount();
		
		if(listCount >0) {
			int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
			
		}
		
		
		return boardDao.boardList(startRow, endRow);
	}

	@Override
	public void insertBoard(Board b) {
		boardDao.insertBoard(b);

	}

	@Override
	public void deleteBoard(int b) {
		boardDao.deleteBoard(b);

	}

	@Override
	public void updateBoard(Board b) {
		boardDao.updateBoard(b);

	}

	@Override
	public Board detailBoard(Board b) {

		return boardDao.detailBoard(b);
	}

}
