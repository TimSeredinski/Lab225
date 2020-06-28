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
@Table(name = "Post")
@Getter
@Setter
@ToString
@AllArgsConstructor
@IdClass(PostID.class)
@NoArgsConstructor
public class Post extends AbstractBean
{
	@Id
	private String postID;
	@Id
	private String accountID;
	@OneToMany
	private List<Comment> comments;
}
