package com.epam.jpa.entity;

import java.io.Serializable;

import com.epam.jpa.entity.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author tsimafei.seradzinski
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class AccountID implements Serializable
{
	private String accountNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
}
