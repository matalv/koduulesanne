package com.backend_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdditionController {
    private List<NumberAddition> additions = new ArrayList<>();

    @GetMapping("/addition")
    public NumberAddition performAddition(@RequestParam int num1, @RequestParam int num2) {
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
            throw new IllegalArgumentException("Values must be between 0 and 100 (inclusive)");
        }

        int sum = num1 + num2;
        NumberAddition addition = new NumberAddition(num1, num2, sum);
        additions.add(addition);
        return addition;
    }

    @GetMapping("/mergeSearch")
    public List<NumberAddition> mergeSearch(@RequestParam(required = false) Integer searchNumber,
                                            @RequestParam String sortOrder) {
        if (!sortOrder.equalsIgnoreCase("ascending") && !sortOrder.equalsIgnoreCase("descending")) {
            throw new IllegalArgumentException("Sort order must be 'ascending' or 'descending'");
        }
    
        List<NumberAddition> result = new ArrayList<>();
    
        if (searchNumber != null) {
            for (NumberAddition addition : additions) {
                if (addition.getNum1() == searchNumber ||
                    addition.getNum2() == searchNumber ||
                    addition.getSum() == searchNumber) {
                    result.add(addition);
                }
            }
        } else {
            result.addAll(additions);
        }
    
        result.sort((a1, a2) -> {
            if (sortOrder.equalsIgnoreCase("ascending")) {
                return Integer.compare(a1.getSum(), a2.getSum());
            } else {
                return Integer.compare(a2.getSum(), a1.getSum());
            }
        });
    
        return result;
    }
}
