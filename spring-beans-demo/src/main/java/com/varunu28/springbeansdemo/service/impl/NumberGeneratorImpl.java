package com.varunu28.springbeansdemo.service.impl;

import com.varunu28.springbeansdemo.service.EvenNumberGenerator;
import com.varunu28.springbeansdemo.service.OddNumberGenerator;

public class NumberGeneratorImpl implements EvenNumberGenerator, OddNumberGenerator {

    private int evenNumber;
    private int oddNumber;

    public NumberGeneratorImpl() {
        System.out.println("NumberGeneratorImpl constructor called");
        this.evenNumber = 2;
        this.oddNumber = 1;
    }

    @Override
    public int generateEvenNumber() {
        int result = evenNumber;
        evenNumber += 2;
        return result;
    }

    @Override
    public int generateOddNumber() {
        int result = oddNumber;
        oddNumber += 2;
        return result;
    }
}
