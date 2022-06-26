package com.example.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MemberForm;
import com.example.demo.entity.Members;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder pswEncorder;
	
	
	public Members create(MemberForm memberForm) {
		Members member 
			= new Members(memberForm.getUsernsme(), pswEncorder.encode(memberForm.getPassword())
					, memberForm.getEmail());	
		memberRepository.save(member);		
		return member;
		
	}
}
