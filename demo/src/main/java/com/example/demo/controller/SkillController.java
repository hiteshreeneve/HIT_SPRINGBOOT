package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Resources;
import com.example.demo.model.Skills;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class SkillController {
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@GetMapping("/skills")
	@ResponseBody
	public Skills getResourcesBySkilss(@RequestParam String skillname){
		System.out.println(skillname);
		return skillRepository.findBySkillName(skillname);
		

		
	}
}
