package br.com.praticaintegradora1.praticaintegradora1;

public class RomanNumbersDAO {
    private Integer number;
    private String romanNumber;
    public RomanNumbersDAO(Integer number, String romanNumber) {
        this.number = number;
        this.romanNumber = romanNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public String getRomanNumber() {
        return romanNumber;
    }
}
