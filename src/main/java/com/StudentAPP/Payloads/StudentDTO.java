package com.StudentAPP.Payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

	private int student_ID;
	@NotEmpty(message="Name cannot be Null")
	private String student_Name;
	@NotEmpty(message="Address cannot be empty")
	private String student_Address;
	@NotNull(message = "Age must not be null")
	@Min(value = 10, message = "Age must be at least 18")
	@Max(value = 25, message = "Age must be at most 100")
	private int student_Age;
	@NotEmpty(message="Gender cannot be empty")
	private String gender;
	@NotEmpty(message="Email cannot be empty")
	@Email(message="Email ID is not Valid")
	private String email_ID;
	@NotNull(message = "Phone Number must not be null")
	private int phone_Number;
}
