package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Resource" , schema = "hr")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Resources implements Serializable {
	public Resources() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getResourceId() {
		return resourceId;
	}

	public Resources(Long resourceId, String resourceName, int experience, Date createdAt, Date updatedAt) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.experience = experience;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_Id")
	private Long resourceId;
	@Column(name = "resource_Name")
	private String resourceName;
	@Column(name = "experience")
	private int experience;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
    @ManyToMany( fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "resource_skill",
            joinColumns = { @JoinColumn(name = "resource_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") })
    private Set<Skills> skils = new HashSet<>();

	public Set<Skills> getSkils() {
		return skils;
	}

	public void setSkils(Set<Skills> skils) {
		this.skils = skils;
	}

}
