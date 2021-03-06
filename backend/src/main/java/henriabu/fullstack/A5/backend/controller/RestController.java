package henriabu.fullstack.A5.backend.controller;

import henriabu.fullstack.A5.backend.model.Equation;
import henriabu.fullstack.A5.backend.repository.EquationRepository;
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
    public ResponseEntity<List<String>> getLog(@RequestParam int numberOfEquations){
        List<String> equations = new ArrayList<>();
        try{    
            for(Equation equation: repository.findXNumberOfExporessions(numberOfEquations)){
                equations.add(equation.writeExpression());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(equations, HttpStatus.OK);
    }



    @PostMapping("/calculation")
    public ResponseEntity<Double> createEquation(@RequestBody Equation equation){
        try{
            equation.calculateAnswer();

            repository.save(equation);

            return new ResponseEntity<>(equation.calculateAnswer(), HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    

    

}
