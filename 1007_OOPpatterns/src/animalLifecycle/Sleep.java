package animalLifecycle;

import animaLinterface.Animal;


public class Sleep implements Command {

    private Animal animal;
    public Sleep(Animal animal){
        this.animal = animal;
    }
    @Override
    public void execute() {
        animal.sleep();
    }
}
