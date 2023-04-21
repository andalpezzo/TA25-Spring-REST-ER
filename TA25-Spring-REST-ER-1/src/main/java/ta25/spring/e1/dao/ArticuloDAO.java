package ta25.spring.e1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta25.spring.e1.dto.Articulo;

public interface ArticuloDAO extends JpaRepository<Articulo, Long> {

}
