package math.gpacalculator.service;

import org.springframework.stereotype.Component;
import java.util.*;
import math.gpacalculator.dto.Gpa;
import math.gpacalculator.dto.Result;

@Component
public class GpaCalculatorServiceImpl implements GpaCalculatorService {
    @Override
    public Gpa calculate(List<List<Result>> results){
        List<Double> yearlyGpa = new ArrayList<>();
        Integer totalCredits = 0;
        Double totalGradePoints = 0.0;

        for(List<Result> yearlyResults : results){
            Integer totalCreditsOfYear = 0;
            Double totalGradePointsofYear = 0.0;
            for(Result result : yearlyResults){
                totalCreditsOfYear = totalCreditsOfYear + result.getNumberOfCredits();
                Double gradePoint = result.getNumberOfCredits() * getGradeValue(result.getGrade());
                totalGradePointsofYear = totalGradePointsofYear + gradePoint;
            }
            yearlyGpa.add(totalGradePointsofYear / totalCreditsOfYear);
            totalCredits = totalCredits + totalCreditsOfYear;
            totalGradePoints = totalGradePoints + totalGradePointsofYear;
        }

        Double cumulativeGpa = totalGradePoints / totalCredits;

        Gpa gpa = Gpa.builder()
        .yearlyGpa(yearlyGpa)
        .cumulativeGpa(cumulativeGpa)
        .build();
        return gpa;
    } 

    public Double getGradeValue(String grade){
        switch(grade){
            case "A+":
                return 4.0;
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            case "E":
                return 0.0;
            default:
                return 0.0;
        }
    }
}
