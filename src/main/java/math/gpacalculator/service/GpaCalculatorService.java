package math.gpacalculator.service;

import org.springframework.stereotype.Service;
import math.gpacalculator.dto.Gpa;
import java.util.*;
import math.gpacalculator.dto.Result;

@Service
public interface GpaCalculatorService {
    Gpa calculate(List<List<Result>> results);
}
