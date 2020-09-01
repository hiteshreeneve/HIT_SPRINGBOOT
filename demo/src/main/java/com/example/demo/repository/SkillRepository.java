package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Skills;
import java.lang.String;


public interface SkillRepository extends JpaRepository<Skills, Long> {
	 Skills findBySkillName(String skillname);
	 
}
