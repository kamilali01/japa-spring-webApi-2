package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ILanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private ILanguageService languageService;

    @Autowired
    public LanguagesController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/get")
    public GetByIdLanguageResponse get(int id) {
        return languageService.get(id);
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest language) throws Exception {
        languageService.add(language);
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        languageService.delete(id);
    }

    @PutMapping("/update")
    public void update(UpdateLanguageRequest language) {
        languageService.update(language);
    }

}
