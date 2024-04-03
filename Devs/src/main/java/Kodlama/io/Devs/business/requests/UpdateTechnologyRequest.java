package Kodlama.io.Devs.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {

    private int id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private int LanguageId;

}
