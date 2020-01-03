package br.com.dessert.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dessert.api.entity.Dessert;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {

}
