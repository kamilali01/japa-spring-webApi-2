package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ITechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTecnhologiesResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologiesResponse;

@RestController
@RequestMapping("/api/controllers")
public class TechnologiesController {
private ITechnologyService technologyService;

@Autowired
public TechnologiesController(ITechnologyService technologyService) {
    this.technologyService = technologyService;
}

@GetMapping("/getall")
public List<GetAllTecnhologiesResponse> getAll(){
    return technologyService.getAll();
}

@GetMapping("/get")
public GetByIdTechnologiesResponse get(int id){
    return technologyService.getById(id);
}

@PostMapping("/add")
public void add(CreateTechnologyRequest technology){
    technologyService.add(technology);
}

@PutMapping("/update")
public void update(UpdateTechnologyRequest technology){
    technologyService.update(technology);
}

@DeleteMapping("/delete")
public void delete(int id){
    technologyService.delete(id);
}


}
