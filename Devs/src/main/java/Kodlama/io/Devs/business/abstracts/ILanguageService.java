package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;

public interface ILanguageService {
    List<GetAllLanguagesResponse> getAll();

    GetByIdLanguageResponse get(int id);

    void add(CreateLanguageRequest language) throws Exception;

    void delete(int id);

    void update(UpdateLanguageRequest language);
}
