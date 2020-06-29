package com.epam.jpa.entity;

import java.util.List;

import javax.persistence.*;

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
@NoArgsConstructor
public class Post extends AbstractBean
{
	@EmbeddedId
	private PostID postID;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comment> comments;
	@ManyToOne
	private Account account;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post) o;
		if(!post.getPostID().getPostID().equals(this.getPostID().getPostID()))
		{
			return false;
		}
		if(!post.getPostID().getAccountID().equals(this.getPostID().getAccountID()))
		{
			return false;
		}
		if(!post.getAccount().equals(this.getAccount()))
		{
			return false;
		}

		return post.getComments().equals(this.getComments());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 829;
		result = prime * result + postID.getAccountID().length();
		result = prime * result + postID.getPostID().length();
		result = prime * result + comments.size();
		result = prime * result + account.getName().length();

		return result;
	}
}
