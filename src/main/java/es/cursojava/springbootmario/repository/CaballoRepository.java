package es.cursojava.springbootmario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.springbootmario.entities.CaballoEntity;

public interface CaballoRepository extends JpaRepository<CaballoEntity, Long> {
    boolean existsByDorsal(Integer dorsal);
}
