package com.epam.travel_agency.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.travel_agency.entity.Account;
import com.epam.travel_agency.entity.AccountID;

/**
 * @author tsimafei.seradzinski
 */
@Repository
public interface AccountDAO extends CrudRepository<Account, AccountID>
{
	
}
