package com.epam.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.jpa.entity.Account;
import com.epam.jpa.entity.AccountID;


/**
 * @author tsimafei.seradzinski
 */
@Repository
public interface AccountDAO extends CrudRepository<Account, AccountID>
{
	
}
