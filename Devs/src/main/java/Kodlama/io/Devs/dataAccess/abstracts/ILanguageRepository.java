package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import Kodlama.io.Devs.entities.concretes.Language;

public interface ILanguageRepository extends JpaRepository<Language, Integer> {
}
