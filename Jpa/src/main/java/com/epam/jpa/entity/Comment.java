package com.epam.jpa.entity;

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
@Table(name = "Comment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment extends AbstractBean
{
	@Id
	@GeneratedValue
	private int commentID;
	private String text;
	@OneToOne
	private Account account;
	@ManyToOne
	private Post post;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comment comment = (Comment) o;
		if(comment.commentID != this.commentID)
		{
			return false;
		}
		if(!comment.getText().equals(this.getText()))
		{
			return false;
		}
		if(!comment.getAccount().getName().equals(this.getAccount().getName()))
		{
			return false;
		}

		return comment.getPost().equals(this.getPost());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 829;
		result = prime * result + commentID;
		result = prime * result + text.length();
		result = prime * result + account.getName().length();
		result = prime * result + post.getPostID().getPostID().length();

		return result;
	}
}
