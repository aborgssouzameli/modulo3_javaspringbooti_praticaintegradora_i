package br.com.praticaintegradora1.praticaintegradora1.controller;

import br.com.praticaintegradora1.praticaintegradora1.RomanNumbersDAO;
import br.com.praticaintegradora1.praticaintegradora1.service.RomanNumbersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MainController {
    private RomanNumbersService romanNumbersService = new RomanNumbersService();

    @GetMapping( "/convert-natural-number-to-roman/{naturalNumber}")
    public ResponseEntity<RomanNumbersDAO> convertNaturalNumberToRoman (@PathVariable Integer naturalNumber) {
        String romanNumber = "";
        romanNumber = this.convertToRoman(naturalNumber);
        RomanNumbersDAO romamNumberDAO = new RomanNumbersDAO(naturalNumber, romanNumber);
        if (romanNumber.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(romamNumberDAO);
    }

    /*Outra forma de fazer a leitura de uma lista: List<Veiculo> veiculoList = mapper.readValue(new File("veiculo.json"), new TypeReference<List<veiculo>>() {});*/

    /* List<Pet> petList = mapper.readValue(new File("pet.json"), new TypeReference<List<Pet>>() {}); */

    @GetMapping("/convert-roman-number-to-natural/{romanNumber}")
    public ResponseEntity<RomanNumbersDAO> convertRomanNumberToNatural (@PathVariable String romanNumber) {
        RomanNumbersDAO romamNumberDAO;
        Integer naturalNumber = 0;
        naturalNumber = this.convertRomanToNatural(romanNumber);
        romamNumberDAO = new RomanNumbersDAO(naturalNumber, romanNumber);
        return ResponseEntity.ok(romamNumberDAO);
    }

    private String convertToRoman (Integer number) {
        return romanNumbersService.convertNaturalNumberToRoman(number);
    }

    private Integer convertRomanToNatural (String romanNumber) {
        return romanNumbersService.convertRomanNumberToNatural(romanNumber);
    }
}
