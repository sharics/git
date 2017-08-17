package com.springboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboard.domain.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Override
	public List<Board> boardList() {
		return jdbcTemplate.query(
				"SELECT * FROM board",
				new RowMapper<Board>() {
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board b = new Board();
						b.setBno(rs.getInt("bno"));
						b.setTitle(rs.getString("title"));
						b.setWriter(rs.getString("writer"));
						b.setContent(rs.getString("content"));
						b.setRead_count(rs.getInt("read_count"));
						b.setReg_date(rs.getTimestamp("reg_date"));
						b.setPass(rs.getString("pass"));
						return b;
					}
				}
				);
	}

	@Override
	public List<Board> boardList(int startRow, int endRow) {
		return jdbcTemplate.query(
				"SELECT * FROM "
				+ " (SELECT ROWNUM num, ta.* FROM "
				+ " (SELECT * FROM board ORDER BY bno DESC) ta) "
				+ " WHERE num BETWEEN ? and ?",
				new RowMapper<Board>() {
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board b = new Board();
						b.setBno(rs.getInt("bno"));
						b.setTitle(rs.getString("title"));
						b.setWriter(rs.getString("writer"));
						b.setContent(rs.getString("content"));
						b.setRead_count(rs.getInt("read_count"));
						b.setReg_date(rs.getTimestamp("reg_date"));
						b.setPass(rs.getString("pass"));
						return b;
					}
				}, startRow, endRow);
	}

	@Override
	public void insertBoard(Board b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(Board b) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board detailBoard(Board b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardCount() {
		String query="SELECT COUNT(*) FROM board";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

}
