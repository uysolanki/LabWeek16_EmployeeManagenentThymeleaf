package com.greatlearning.EmployeeManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Data

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //AUTO_INCREMENT
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
}
