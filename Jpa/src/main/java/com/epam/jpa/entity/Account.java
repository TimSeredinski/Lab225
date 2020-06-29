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
@Table(name = "Account")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Account.findAll", query="SELECT acc FROM Account acc")
public class Account extends AbstractBean
{
	@EmbeddedId
	private AccountID accountID;
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		if(!account.getAccountID().getAccountNumber().equals(this.getAccountID().getAccountNumber()))
		{
			return false;
		}
		if(account.getAccountID().getAccountType().ordinal() != this.getAccountID().getAccountType().ordinal())
		{
			return false;
		}

		return account.getName().equals(this.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 829;
		result = prime * result + accountID.getAccountType().ordinal();
		result = prime * result + accountID.getAccountNumber().length();
		result = prime * result + name.length();

		return result;
	}
}
