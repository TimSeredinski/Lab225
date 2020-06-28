package com.epam.travel_agency.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "Comment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends AbstractBean
{
	@Id
	private int commentID;
	private String text;
//	@OneToOne(mappedBy = "account")
//	private Account account;
//	@ManyToOne
//	private Post post;
}
