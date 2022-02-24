package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class UtilisateurControleur{
	@Autowired
	IUtilisateurService utilisateurService;
	
//	@GetMapping(value="utilisateurs") // equivalent de @RequestMapping(value="utilisateurs",method = RequestMethod.GET)
//	public List<Utilisateur> findAll(){
//		return utilisateurService.findAll();
//	}
	
	@GetMapping(value="utilisateurs/{idu}")  //localhost:8080/utilisateurs/6
	public Utilisateur findOne(@PathVariable("idu")Long id) {
		return utilisateurService.findOne(id);
	}
	
	@PostMapping("utilisateurs") //=> objet utilisateur dans le body
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}
	
	@DeleteMapping("utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur")Long idUtilisateur) {
		utilisateurService.delete(idUtilisateur);
	}
	
	@PutMapping("utilisateurs/{idu}")
	public Utilisateur updateUtilisateur(@PathVariable("idu") long idUtilisateur,@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur=utilisateurService.findOne(idUtilisateur);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(utilisateur.getPassword());
		currentUtilisateur .setRoles(utilisateur.getRoles());
		return utilisateurService.save(currentUtilisateur);
	}
	
	@GetMapping("utilisateurs")
	public int nbUser() {
		return utilisateurService.nbUtilisateur();
	}
}
