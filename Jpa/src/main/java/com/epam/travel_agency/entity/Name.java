package com.epam.travel_agency.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Name")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Name
{
	@Id
	private String id;
	private String name;
	
}
