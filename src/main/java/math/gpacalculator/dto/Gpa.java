package math.gpacalculator.dto;

import java.util.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gpa {
    private List<Double> yearlyGpa;
    private Double cumulativeGpa;
}
