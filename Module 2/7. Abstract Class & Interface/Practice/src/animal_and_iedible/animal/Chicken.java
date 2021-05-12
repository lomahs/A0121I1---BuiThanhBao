package animal_and_iedible.animal;

import animal_and_iedible.edible.IEdible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "Fried";
    }
}
