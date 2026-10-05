package com.bptn.course._06_abstraction.smart_home_demo;
//SmartThermostat.java - Our Smart Thermostat product!
public class SmartThermostat extends SmartDevice implements Controllable {
 double currentTemp;
 double targetTemp;

 public SmartThermostat(String name) {
     super(name); // Call the SmartDevice constructor
     this.currentTemp = 22.0; // Starts at a comfy temp
     this.targetTemp = 22.0;
 }

 // --- We MUST fill in these abstract methods from SmartDevice ---
 @Override
 public void turnOn() {
     isOn = true;
     System.out.println(name + " Thermostat: Heating/Cooling ON. Current: " + currentTemp + "°C, Target: " + targetTemp + "°C.");
 }

 @Override
 public void turnOff() {
     isOn = false;
     System.out.println(name + " Thermostat: Heating/Cooling OFF.");
 }

 // --- We MUST fill in this method from the Controllable interface ---
 @Override
 public void changeSetting(String settingName, String value) {
     if (isOn) { // Only change settings if it's on!
         if (settingName.equalsIgnoreCase("targetTemp")) {
             try {
                 double newTarget = Double.parseDouble(value);
                 this.targetTemp = newTarget;
                 System.out.println(name + " Thermostat: Target temperature set to " + newTarget + "°C.");
             } catch (NumberFormatException e) {
                 System.out.println(name + " Thermostat: Oops! Invalid temperature value. Please use a number.");
             }
         } else {
             System.out.println(name + " Thermostat: Sorry, I don't know the setting '" + settingName + "'.");
         }
     } else {
         System.out.println(name + " Thermostat is off. Turn on to change settings.");
     }
 }
}