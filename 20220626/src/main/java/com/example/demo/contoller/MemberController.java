package com.example.demo.contoller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.MemberForm;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/members")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/register")
	public String register(MemberForm memberForm) {		
		return "member_register";		
	}
	
	@PostMapping("/register")
	public String register(@Valid MemberForm memberForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "member_register";
		if(!memberForm.getPassword().equals(memberForm.getPassword_confirm())){
			bindingResult.rejectValue("password_confirm", "paswordInCorrect","2개의 패스워드가 일치하지 않습니다.");
			return "member_register";
		}		
		memberService.create(memberForm);
		return "redirect:/";
	}

}
