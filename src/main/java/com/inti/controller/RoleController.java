package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;

@RestController //RestFul WS (post,put,get et delete)
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	@GetMapping(value="roles") // equivalent de @RequestMapping(value="roles",method = RequestMethod.GET)
	public List<Role> findAll(){
		return roleService.findAll();
	}
	
	@GetMapping(value="roles/{idr}")  //localhost:8080/roles/6
	public Role findOne(@PathVariable("idr")Long id) {
		return roleService.findOne(id);
	}
	
	@PostMapping("roles") //=> objet role dans le body
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}
	
	@DeleteMapping("roles/{idRole}")
	public void deleteRole(@PathVariable("idRole")Long idRole) {
		roleService.delete(idRole);
	}
	
	@PutMapping("roles/{idr}")
	public Role updateRole(@PathVariable("idr") long idRole,@RequestBody Role role) {
		Role currentRole=roleService.findOne(idRole);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(currentRole);
	}
}
