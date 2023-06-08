package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeDTO {

	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	private String userid;
	
	public boolean passwordEquals() {
		return newPassword.equals(confirmPassword);
	}
}
