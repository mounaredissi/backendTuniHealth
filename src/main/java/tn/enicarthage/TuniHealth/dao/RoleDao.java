package tn.enicarthage.TuniHealth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
