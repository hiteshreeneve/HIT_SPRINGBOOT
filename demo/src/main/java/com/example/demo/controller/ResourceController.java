package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ResourceController {
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	/*@GetMapping("/resources/{resourceId}")
	public Optional<Resources> getResourceById(@PathVariable(value="resourceId") Long resourceId) {
		
		
		return resourceRepository.findById(resourceId);
	}*/
	
	@GetMapping("/resources/skills")
	@ResponseBody
	public List<String> getResourcesBySkilss(@RequestParam String skillname,@RequestParam Integer maxexperience){
		
		System.out.println(skillname);
		String[] arr = skillname.split(",");
		Set<Skills> set = new HashSet<>();
		for(int i =0; i<arr.length;i++) {
				set.add(skillRepository.findBySkillName(arr[i]));
		}
		Set<Resources> resources  = null;
		if(maxexperience == null) {
		 resources = resourceRepository.findBySkilsIn(set);
		
		} else {
			resources = resourceRepository.findByExperienceLessThanAndSkilsIn(maxexperience,set);
		}		
		List<String> response = resources.parallelStream().map(r->r.getResourceName()).collect(Collectors.toList());
			
		return response;
		
	}
}
