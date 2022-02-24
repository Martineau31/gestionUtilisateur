package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Role;


@Repository //spring creer une bean=> roleRepository
public interface RoleRepository extends JpaRepository<Role,Long>{
	List<Role> findByLibelle(String libelle);
}
