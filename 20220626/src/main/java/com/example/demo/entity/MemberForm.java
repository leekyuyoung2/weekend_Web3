package com.example.demo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
	@Size(min=3, max=25)
	@NotEmpty(message="사용자 id는 필수 입니다.")
	private String usernsme;
	
	@NotEmpty(message="비밀번호는 필수 입니다.")
	private String password;
	@NotEmpty(message="비밀번호 확인은 필수 입니다.")
	private String password_confirm;  // 확인용
	
	@NotEmpty(message="비밀번호 확인은 필수 입니다.")
	@Email
	private String email;
}
