package henriabu.fullstack.A5.backend.repository;

import java.util.List;

import henriabu.fullstack.A5.backend.model.Equation;

public interface EquationRepository {
    int save(Equation equation);
    List<Equation> findAll();
}
