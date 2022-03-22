package henriabu.fullstack.A5.backend.repository;

import java.util.List;

import com.fasterxml.jackson.databind.BeanProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import henriabu.fullstack.A5.backend.model.Equation;
@Repository
public class JdbcEquationRepository implements EquationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Equation> findAll() {
        return jdbcTemplate.query("SELECT * from equation", BeanPropertyRowMapper.newInstance(Equation.class));
    }
    @Override
    public int save(Equation equation){
        return jdbcTemplate.update(
            "INSERT INTO EQUATIONS (id, num1, num2, operator, answer) VALUES (?, ?, ?, ?, ?)",
            new Object[]{ equation.getId(), equation.getNum1(), equation.getNum2(), equation.getOp(), equation.getAnswer()}
        );
    }
    
}
