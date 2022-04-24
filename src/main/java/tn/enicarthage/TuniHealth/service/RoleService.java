package tn.enicarthage.TuniHealth.service;

import tn.enicarthage.TuniHealth.dao.RoleDao;
import tn.enicarthage.TuniHealth.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
