package Kodlama.io.Devs.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageResponse {
    private int id;
    private String name;
    private List<GetByIdTechnologiesResponse> technologies;
}
