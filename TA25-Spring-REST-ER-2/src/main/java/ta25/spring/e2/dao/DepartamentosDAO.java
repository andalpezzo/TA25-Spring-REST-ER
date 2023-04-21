package ta25.spring.e2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ta25.spring.e2.dto.Departamentos;

public interface DepartamentosDAO extends JpaRepository<Departamentos, Long> {
	
}
