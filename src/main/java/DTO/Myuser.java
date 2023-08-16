package DTO;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Myuser {
	@Id
	String name;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String email;
	String password;
	long phone;
	String gender;
	LocalDate dob;
	String address;
	String[] lang;
	
	@OneToMany
	List<Task> tasks;
	
}
