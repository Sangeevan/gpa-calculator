package math.gpacalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import math.gpacalculator.service.GpaCalculatorService;
import math.gpacalculator.dto.Gpa;
import math.gpacalculator.dto.Result;

@RestController
public class GpaCalculatorController {

  @Autowired
  private GpaCalculatorService gpaCalculatorService;

  @PostMapping("/calculate-gpa")
  public Gpa calculateGpa(@RequestBody List<List<Result>> results) {
    return gpaCalculatorService.calculate(results);
  }
}
