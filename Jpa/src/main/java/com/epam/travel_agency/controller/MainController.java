package com.epam.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.travel_agency.dao.AccountDAO;
import com.epam.travel_agency.entity.Account;

/**
 * @author tsimafei.seradzinski
 */
@Controller
public class MainController {

	@Autowired
	private AccountDAO accountDAO;

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		Iterable<Account> all = accountDAO.findAll();

		StringBuilder sb = new StringBuilder();

		all.forEach(a -> sb.append(a.getName() + "<br>"));

		return sb.toString();
	}

}
