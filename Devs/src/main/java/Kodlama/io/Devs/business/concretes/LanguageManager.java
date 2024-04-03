package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ILanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologiesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ILanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class LanguageManager implements ILanguageService {
    private ILanguageRepository languageRepository;

    @Autowired
    public LanguageManager(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<GetAllLanguagesResponse> languagesResponses = new ArrayList<>();
        List<Language> languages = languageRepository.findAll();

        

        for (Language language : languages) {
            GetAllLanguagesResponse languagesResponse = new GetAllLanguagesResponse();

            List<GetByIdTechnologiesResponse> technologies =new ArrayList<GetByIdTechnologiesResponse>();
            for (Technology tech : language.getTechnologies()) {
                GetByIdTechnologiesResponse technology=new GetByIdTechnologiesResponse();
                technology.setId(tech.getId());
                technology.setName(tech.getName());
                technologies.add(technology);
            }

            languagesResponse.setId(language.getId());
            languagesResponse.setName(language.getName());
            languagesResponse.setTechnologies(technologies);
            languagesResponses.add(languagesResponse);
        }

        return languagesResponses;
    }

    @Override
    public GetByIdLanguageResponse get(int id) {
        
        Language language=languageRepository.findById(id).orElseThrow();
        GetByIdLanguageResponse languageResponse=new GetByIdLanguageResponse();

        List<GetByIdTechnologiesResponse> technologies =new ArrayList<GetByIdTechnologiesResponse>();
        for (Technology tech : language.getTechnologies()) {
            GetByIdTechnologiesResponse technology=new GetByIdTechnologiesResponse();
            technology.setId(tech.getId());
            technology.setName(tech.getName());
            technologies.add(technology);
        }

        languageResponse.setId(language.getId());
        languageResponse.setName(language.getName());
        languageResponse.setTechnologies(technologies);


        return languageResponse;
    }

    @Override
    public void add(CreateLanguageRequest languageRequest) throws Exception {

        Language language=new Language();
        language.setName(languageRequest.getName());
        


        if (findName(language.getName())) {
            throw new Exception("!!Bu isim zaten kullaniliyor!!");
        }
        if (language.getName().isEmpty()) {
            throw new Exception("!!Isim bos gecilemez!!");
        }
        languageRepository.save(language);
    }

    private boolean findName(String name) {
        for (Language iterableElement : languageRepository.findAll()) {
            if (name.equals(iterableElement.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageRequest languageRequest) {
        Language language=languageRepository.findById(languageRequest.getId()).orElseThrow();
        language.setName(languageRequest.getName());
        languageRepository.save(language);
        
    }

}
