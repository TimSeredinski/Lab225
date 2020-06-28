//package com.epam.travel_agency.dao.impl;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//
//import com.epam.travel_agency.entity.Account;
//
///**
// * @author tsimafei.seradzinski
// */
//public class AccountRepository
//{
//
//	@PersistenceContext
//	private EntityManager em;
//
//	public Account create(Account bean)
//	{
//		return em.merge(bean);
//	}
//
//	public Account get(int id)
//	{
//		try
//		{
//			return em.find(Account.class, id);
//		}
//		catch (NoResultException e)
//		{
//			return null;
//		}
//	}
//
//	public Account update(Account bean)
//	{
//		return em.merge(bean);
//	}
//
//	public void delete(int id)
//	{
//		Account bean = get(id);
//		if (bean != null)
//		{
//			em.remove(bean);
//		}
//	}
//}
