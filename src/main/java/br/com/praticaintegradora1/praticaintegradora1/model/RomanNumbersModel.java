package br.com.praticaintegradora1.praticaintegradora1.model;
import java.util.HashMap;
import java.util.Map;

public class RomanNumbersModel {
    private static Integer [] naturalNumbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String []  romanNumbers = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    Map<Character, Integer> basicRomanNumbers = new HashMap<>();

    public RomanNumbersModel() {
        basicRomanNumbers.put('I', 1);
        basicRomanNumbers.put('V', 5);
        basicRomanNumbers.put('X', 10);
        basicRomanNumbers.put('L', 50);
        basicRomanNumbers.put('C', 100);
        basicRomanNumbers.put('D', 500);
        basicRomanNumbers.put('M', 1000);
    }

    public Integer[] getNaturalNumbers() {
        return naturalNumbers;
    }

    public String[] getRomanNumbers() {
        return romanNumbers;
    }

    public Map<Character, Integer> getBasicRomanNumbers() {

        return this.basicRomanNumbers;
    }
}
