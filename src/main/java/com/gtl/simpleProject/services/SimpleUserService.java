package com.gtl.simpleProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtl.simpleProject.entities.SimpleUser;
import com.gtl.simpleProject.repositories.SimpleUserRepository;

//import br.com.projetoFullStack.projetoFull.services.exceptions.ResourceNotFoundException;

@Service
public class SimpleUserService {
	
	@Autowired
	private SimpleUserRepository repository;
	
	public List<SimpleUser> findAll(){
		return repository.findAll();
	}
	
	public SimpleUser findById(Integer id) {
		Optional<SimpleUser> obj = repository.findById(id);
		return obj.get();
		//return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public SimpleUser insert(SimpleUser obj) {
		return repository.save(obj);
	}

}
