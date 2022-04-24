package tn.enicarthage.TuniHealth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
