package henriabu.fullstack.A5.backend.controller;

import henriabu.fullstack.A5.backend.model.Equation;
import henriabu.fullstack.A5.backend.repository.EquationRepository;
import henriabu.fullstack.A5.backend.service.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.net.ssl.HttpsURLConnection;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {
    

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    EquationRepository repository;

    @GetMapping("/calculation")
    public ResponseEntity<List<Equation>> getAll(){
        List<Equation> equations = new ArrayList<>();
        try{
            repository.findAll().forEach(equations::add);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        for (Equation equation : equations) {
            System.out.println(equation.getAnswer());
        }
        return new ResponseEntity<>(equations, HttpStatus.OK);
    }

    @PostMapping("/calculation")
    public ResponseEntity<String> createEquation(@RequestBody Equation equation){
        try{
            repository.save(equation);
            return new ResponseEntity<>("Equation was added", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    

    

}
