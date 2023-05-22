package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.domain.BookDTO;

@Repository
public class BookDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static {
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
	
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="javadb";
		String password ="1234";
		
		try {
			con = DriverManager.getConnection(url,user,password);
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BookDTO> getRows(){
		List<BookDTO> list = new ArrayList<BookDTO>();
		try {
			
			con= getConnection();
			
			String sql="select * from booktbl";
			
			pstmt=con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt,rs);
		}
		return list;
	}
	
	public boolean insert(BookDTO insertDto) {
		boolean flag = false;
		
		try {
			
			con =getConnection();
			String sql="insert into booktbl(code,title,writer,price,description) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			if(insertDto.getDescription()!=null) {
				pstmt.setString(5, insertDto.getDescription());
			}
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				commit(con);
				flag=true;
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		}
		finally {
			close(con, pstmt);
		}
		return flag;
	}
	
	
	public boolean delete(int code) {
		boolean flag = false;
		try {
		
			con = getConnection();
			String sql ="delete from booktbl where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, code);
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				commit(con);
				flag=true;
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return flag;
	}
	
	public boolean update(BookDTO updateDto) {
		//code가 일치하면 가격 변경
		boolean flag = false;
		try {
		
			con = getConnection();
			String sql ="update booktbl set price=? where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,updateDto.getPrice());
			pstmt.setInt(2,updateDto.getCode());
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				commit(con);
				flag = true;
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return flag;
	}
	
	public BookDTO getRow(int code) {
		BookDTO dto = null;
		try {
			
			con = getConnection();
			String sql ="select booktbl where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto= new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));

			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt,rs);
		}
		return dto;
	}
}
















