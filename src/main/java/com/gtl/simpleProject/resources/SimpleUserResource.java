package com.gtl.simpleProject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gtl.simpleProject.entities.SimpleUser;
import com.gtl.simpleProject.services.SimpleUserService;

@RestController
public class SimpleUserResource {
	
	@Autowired
	private SimpleUserService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<SimpleUser>> findAll(){
		List list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SimpleUser> findById(@PathVariable Integer id){
		SimpleUser obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping(value = "/insert")
	public ResponseEntity<SimpleUser> insert(@RequestBody SimpleUser obj) {
		//System.out.println("Chegou");
		URI uri = null;
		service.insert(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
		
	}


}
