package repository;

import animaLinterface.Animal;
import animalTypes.Elephant;
import animalTypes.Tiger;
import animalTypes.Wolf;
import animalTypes.Zebra;
import itarator.Aggregate;
import itarator.Iterator;


public class AnimalPool implements Aggregate {

    private Animal animals[] = {new Zebra(), new Elephant(), new Tiger(), new Wolf()};

    @Override
    public Iterator getIterator() {
        return new AnimalIterator();
    }


    private class AnimalIterator implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < animals.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return animals[index++];
        }
    }
}