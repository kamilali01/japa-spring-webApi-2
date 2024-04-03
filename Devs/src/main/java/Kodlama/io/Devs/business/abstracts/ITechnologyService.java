package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTecnhologiesResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologiesResponse;

public interface ITechnologyService {
    List<GetAllTecnhologiesResponse> getAll();

    GetByIdTechnologiesResponse getById(int id);

    void add(CreateTechnologyRequest technology);

    void update(UpdateTechnologyRequest technology);

    void delete(int id);

}
