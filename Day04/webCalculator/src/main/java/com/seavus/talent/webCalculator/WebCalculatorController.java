package com.seavus.talent.webCalculator;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebCalculatorController {

    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})

    @ResponseBody
    public int calculate(@RequestParam int leftOperand, @RequestParam char operator, @RequestParam int rightOperand) {

        int result = 0;

        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;

            case '-':
                result = leftOperand - rightOperand;
                break;

        }

        return result;
    }

}

