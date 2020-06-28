package com.epam.travel_agency;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epam.travel_agency.dao.AccountDAO;
import com.epam.travel_agency.dao.NameDAO;
import com.epam.travel_agency.entity.Account;
import com.epam.travel_agency.entity.Name;

/**
 * @author tsimafei.seradzinski
 */
@Component
public class DataInit implements ApplicationRunner
{
	private AccountDAO accountDAO;
	private NameDAO nameDAO;

	@Autowired
	public DataInit(AccountDAO accountDAO, NameDAO nameDAO)
	{
		this.accountDAO = accountDAO;
		this.nameDAO = nameDAO;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception
	{

		Account account1 = new Account();
		account1.setAccountType("Default");
		account1.setAccountNumber("1");
		account1.setName("Tim");
		account1.setPosts(new ArrayList<>());

		Account account2 = new Account();
		account2.setAccountType("Default");
		account2.setAccountNumber("1");
		account1.setName("Nick");
		account2.setPosts(new ArrayList<>());

		accountDAO.save(account1);
		accountDAO.save(account2);

		for(Account acc : accountDAO.findAll())
		{
			System.out.println(acc.getName() + "|");
		}

//		Name name = new Name("1", "Tim");
//		nameDAO.save(name);
//
//		System.out.println(nameDAO.findById("1").get().getName());
		
	}

}
