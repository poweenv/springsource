package com.spring.memo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // 클래스를 엔티티로 선언
@SequenceGenerator(name="mem_seq_gen",sequenceName = "mem_seq",allocationSize = 1)
@Builder
public class Memo {

	
	// name : 임의로 이름 설정(필수) , squenceName : mem_seq.nextval, allocarionSize = 증가할 숫자
	// @SequenceGenerator(name="mem_seq_gen",sequenceName = "mem_seq",allocationSize = 1)
	
	// GenerationType : 1) Auto : JPA 구현체가 자동으로 rngus, 2) IDENTITY
	//					3) SEQUENCE : SequenceGenerator
	//					4) 키 생성용 테이블 사용
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")
	@Id
	private Long mno;
	
	@Column(length = 200, nullable=false)
	private String memoText;
}
