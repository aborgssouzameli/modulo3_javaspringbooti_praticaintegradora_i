package br.com.praticaintegradora1.praticaintegradora1.service;

import br.com.praticaintegradora1.praticaintegradora1.model.RomanNumbersModel;
import org.springframework.stereotype.Service;

import java.util.Map;
import static java.util.Collections.nCopies;
import static java.lang.String.join;
@Service
public class RomanNumbersService {

    private RomanNumbersModel model = new RomanNumbersModel();

    public String convertNaturalNumberToRoman(Integer number) {
        Integer[] numbers = this.getNaturalNumbers();
        String[] romamNumbers = this.getRomanNumbers();
        StringBuilder result = new StringBuilder();
        for(int i=0; i< numbers.length; i++){
            int parteInteira = number / numbers[i];
            number -= numbers[i] * parteInteira;
            result.append(join("",nCopies(parteInteira, romamNumbers[i])));
        }
        return result.toString();
    }

    public Integer convertRomanNumberToNatural(String romanNumber) {
        Integer total = 0;
        romanNumber = romanNumber.toUpperCase();
        Map<Character, Integer> basicRomanNumbers = this.getBasicRomanNumbers();
        for(int i = 0; i < romanNumber.length(); i++){
            Character currentChar = romanNumber.charAt(i);
            if(i>0 && basicRomanNumbers.get(currentChar) > basicRomanNumbers.get(romanNumber.charAt(i-1)))
            {
                total += basicRomanNumbers.get(currentChar) - 2 * basicRomanNumbers.get(romanNumber.charAt(i-1));
            }
            else
                total += basicRomanNumbers.get(currentChar);
        }
        return total;
    }

    private Integer[] getNaturalNumbers() {
        return model.getNaturalNumbers();
    }

    private String[] getRomanNumbers() {
        return model.getRomanNumbers();
    }

    public Map<Character, Integer> getBasicRomanNumbers() {
        return model.getBasicRomanNumbers();
    }
}
