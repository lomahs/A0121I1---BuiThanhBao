import { Human } from "./Human.js";
import { Apple } from "./Apple.js";

let Adam = new Human("Adam", 1, 40);
let Eva = new Human("Eva", 0, 30);

Adam.say("Hello. I'm Adam. The most handsome man in the earth.");
Eva.say("Hello Adam. I'm single.");

let apple = new Apple(10);
Adam.say("Do you see that thing?. It looks delicious ");
Eva.eat(apple);
Eva.say("Hmmm. Perfect!!! Let eat together");

while (!apple.isEmpty()) {
    Adam.eat(apple);
    Eva.eat(apple);
    Adam.checkApple(apple);
}

if (apple.isEmpty()) {
    Eva.say("Feeling like a god");
}