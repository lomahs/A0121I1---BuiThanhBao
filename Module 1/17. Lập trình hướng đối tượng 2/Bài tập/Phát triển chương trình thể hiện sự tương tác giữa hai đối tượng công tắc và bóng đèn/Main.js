import { ElectricLamp } from './ElectricLamp.js';
import { SwitchButton } from './SwitchButton.js';

let lamp = new ElectricLamp(0);
let switchButton = new SwitchButton(0, lamp);

for (let i = 0; i < 10; i++) {
    switchButton.switchOn();
    switchButton.switchOff();
}