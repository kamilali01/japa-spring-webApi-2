package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ITechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTecnhologiesResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.ITechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements ITechnologyService{

    private ITechnologyRepository technologyRepository;
    private ILanguageRepository languageRepository;

    

    @Autowired
    public TechnologyManager(ITechnologyRepository technologyRepository,ILanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTecnhologiesResponse> getAll() {
        List<GetAllTecnhologiesResponse> technologiesResponses = new ArrayList<>();
        List<Technology> technologies = technologyRepository.findAll();

        for (Technology technology : technologies) {
            GetAllTecnhologiesResponse technologiesResponse = new GetAllTecnhologiesResponse();
            technologiesResponse.setId(technology.getId());
            technologiesResponse.setName(technology.getName());
            technologiesResponses.add(technologiesResponse);
        }

        return technologiesResponses;
    }

    @Override
    public GetByIdTechnologiesResponse getById(int id) {
        Technology technology=technologyRepository.findById(id).orElseThrow();
        GetByIdTechnologiesResponse response=new GetByIdTechnologiesResponse();
        response.setId(technology.getId());
        response.setName(technology.getName());
        return response;


    }

    @Override
    public void add(CreateTechnologyRequest technology) {
        Technology newTechnology=new Technology();
        newTechnology.setName(technology.getName());
        newTechnology.setLanguage(languageRepository.findById(technology.getLanguageId()).orElseThrow());
        technologyRepository.save(newTechnology);
    }

    @Override
    public void update(UpdateTechnologyRequest technology) {
        Technology updatedTechnology=technologyRepository.findById(technology.getId()).orElseThrow();
        updatedTechnology.setName(technology.getName());
        updatedTechnology.setLanguage(languageRepository.findById(technology.getLanguageId()).orElseThrow());
        technologyRepository.save(updatedTechnology);
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }

}
