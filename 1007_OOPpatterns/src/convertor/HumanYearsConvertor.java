package convertor;

import animaLinterface.Animal;

public class HumanYearsConvertor implements HumanYearsCalculator {

    Animal animal;

    public HumanYearsConvertor(Animal animal){
        this.animal = animal;
    }
    @Override
    public String getHumanEquvalent() {
        double humanYears = (animal.getAge()*2.8);
        return String.valueOf(humanYears);
    }
}
