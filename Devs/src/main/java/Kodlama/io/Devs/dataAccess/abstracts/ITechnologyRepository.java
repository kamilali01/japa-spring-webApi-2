package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.concretes.Technology;

public interface ITechnologyRepository extends JpaRepository<Technology,Integer>{

}
