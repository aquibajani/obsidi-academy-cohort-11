package com.bptn.course._06_abstraction.smart_home_demo;

//SmartHomeControl.java - Our main program to run the Smart Home!
public class SmartHomeControl {
 public static void main(String[] args) {
     System.out.println("--- Welcome to Smart Home Control! ---");

     // Let's get our Smart Light working
     SmartLight livingRoomLight = new SmartLight("Living Room Light");
     livingRoomLight.displayStatus(); // Inherited from SmartDevice
     livingRoomLight.turnOn();       // Implemented from SmartDevice abstract method
     livingRoomLight.dim(50);        // Implemented from Dimmable interface
     livingRoomLight.displayStatus();
     livingRoomLight.turnOff();
     livingRoomLight.dim(20); // This won't work, we coded it not to dim when off!

     System.out.println("\n------------------------------------");

     // Let's get our Smart Thermostat working
     SmartThermostat upstairsThermostat = new SmartThermostat("Upstairs Thermostat");
     upstairsThermostat.displayStatus(); // Inherited from SmartDevice
     upstairsThermostat.turnOn();        // Implemented from SmartDevice abstract method
     upstairsThermostat.changeSetting("targetTemp", "20.5"); // Implemented from Controllable interface
     upstairsThermostat.displayStatus();
     upstairsThermostat.turnOff();
     upstairsThermostat.changeSetting("targetTemp", "23.0"); // Won't change when off!

     System.out.println("\n--- Demonstrating Interface Superpower! ---");

     // Here's the cool part: We can treat devices by their capabilities (interfaces)!
     // This variable can hold *any* object that promises to be Dimmable.
     Dimmable anotherLight = new SmartLight("Bedroom Light"); // A SmartLight IS A Dimmable
     anotherLight.dim(75); // We can call dim because it's Dimmable
     // ERROR if you try: anotherLight.displayStatus(); // Dimmable contract doesn't promise displayStatus()!

     // This variable can hold *any* object that promises to be Controllable.
     Controllable officeThermostat = new SmartThermostat("Office Thermostat"); // A SmartThermostat IS A Controllable
     officeThermostat.changeSetting("targetTemp", "21.0"); // We can call changeSetting because it's Controllable
     // ERROR if you try: officeThermostat.displayStatus(); // Controllable contract doesn't promise displayStatus()!
 }
}
