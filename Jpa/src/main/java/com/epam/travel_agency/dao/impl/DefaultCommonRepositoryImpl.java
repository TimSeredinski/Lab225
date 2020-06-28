//package com.epam.travel_agency.dao.impl;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//
//import com.epam.travel_agency.dao.CommonRepository;
//import com.epam.travel_agency.entity.AbstractBean;
//
///**
// * @author tsimafei.seradzinski
// */
//public class DefaultCommonRepositoryImpl<T extends AbstractBean> implements CommonRepository<T>
//{
//	private final static Logger logger = LoggerFactory.getLogger(DefaultCommonRepositoryImpl.class);
//
//	@PersistenceContext
//	private EntityManager em;
//
//	@Override
//	public T create(T bean)
//	{
//		return em.merge(bean);
//	}
//
//	@Override
//	public T get(int id)
//	{
//		try
//		{
//			return em.find(T, id);
//		}
//		catch (NoResultException e)
//		{
//			logger.info("There is no such data in tour table");
//			return null;
//		}
//	}
//
//	@Override
//	public T update(T bean)
//	{
//		return em.merge(bean);
//	}
//
//	@Override
//	public void delete(int id)
//	{
//		T bean = get(id);
//		if (bean != null)
//		{
//			em.remove(bean);
//		}
//	}
//}
