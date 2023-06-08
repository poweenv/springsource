package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 테스트코드가 스프링프레임워크 안에서 실행
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberAuth {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private DataSource ds;
	
	@Test  // test 메소드임을 알려주는 annotation 무조건 리턴타입 없는 void , parameter x
	public void test() {
		String sql="insert into spring_member_auth(userid,auth) values(?,?)";
		
		for (int i = 0; i < 50; i++) {
			
			try(Connection con=ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				if( i < 20) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(2, "ROLE_MEMBER");
				}else if( i < 40) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(2, "ROLE_MANAGER");
				}else{
					pstmt.setString(1, "admin"+i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
