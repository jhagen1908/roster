package org.cloudfoundry.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID uuid;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String companyGuid;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<PersonStatus> personStatuses;

	Person() {
	}

	public Person(String firstName, String lastName, String email, String phoneNumber, String companyGuid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.companyGuid = companyGuid;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompanyGuid() {
		return companyGuid;
	}

	public void setCompanyGuid(String companyGuid) {
		this.companyGuid = companyGuid;
	}

	public Set<PersonStatus> getPersonStatuses() {
		return personStatuses;
	}

	public void setPersonStatuses(Set<PersonStatus> personStatuses) {
		this.personStatuses = personStatuses;
	}
}
