package com.epam.travel_agency.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.travel_agency.entity.Name;

/**
 * @author tsimafei.seradzinski
 */
public interface NameDAO extends CrudRepository<Name, String>
{
}
