package com.epam.travel_agency.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tsimafei.seradzinski
 */
@Entity
@Table(name = "Account")
@Getter
@Setter
@ToString
@AllArgsConstructor
@IdClass(AccountID.class)
@NoArgsConstructor
public class Account extends AbstractBean
{
	@Id
	private String accountNumber;
	@Id
	private String accountType;
	private String name;

	@OneToMany
	private List<Post> posts;
	
}
