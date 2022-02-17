package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.ConversionBean;
import com.example.demo.repo.ConversionBeanRepo;

@RestController
public class ConversionBeanController {
	@Autowired
	ConversionBeanRepo repo;
	
	@PostMapping("/currency")
	public ConversionBean addCurrency(@RequestBody ConversionBean bean)
		{
			return repo.save(bean);
		}
	@GetMapping("/currencies/{id}")
	public ResponseEntity<ConversionBean> getConversionBeanById(@PathVariable int id)
	{
		Optional<ConversionBean> optional = repo.findById(id);
		if(optional.isPresent())
		{
			return new ResponseEntity<ConversionBean>(optional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<ConversionBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/currencies")
	public ResponseEntity<List<ConversionBean>>getConversionBeans()
	{
		List<ConversionBean> ConversionBeans=repo.findAll();
		if(ConversionBeans.size()>0)
		{
			return new ResponseEntity<List<ConversionBean>>(ConversionBeans,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<ConversionBean>>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/currencies/{id}")
	public ResponseEntity<ConversionBean> deleteConversionBean(@PathVariable int id) {
		Optional<ConversionBean> optional = repo.findById(id);
		if(optional.isPresent())
		{
			ConversionBean ConversionBean = optional.get();
			repo.delete(ConversionBean);
			return new ResponseEntity<ConversionBean>(optional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<ConversionBean>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/currencies/{id}/{name}")
	public ResponseEntity<ConversionBean> updateConversionBean(@PathVariable int id, @PathVariable String name) {
		Optional<ConversionBean> optional = repo.findById(id);
		if(optional.isPresent())
		{
			ConversionBean ConversionBean=optional.get();
			ConversionBean.setValueTo(name);
			return new ResponseEntity<ConversionBean>(repo.save(ConversionBean),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<ConversionBean>(HttpStatus.NOT_FOUND);
		}
	}
	

}
