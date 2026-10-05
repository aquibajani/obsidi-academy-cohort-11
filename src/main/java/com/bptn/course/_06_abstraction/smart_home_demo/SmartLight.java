package com.bptn.course._06_abstraction.smart_home_demo;
//SmartLight.java - Our Smart Light product!
public class SmartLight extends SmartDevice implements Dimmable {
 int brightness; // A specific detail for lights

 public SmartLight(String name) {
     super(name); // Call the SmartDevice constructor to set the name
     this.brightness = 0; // Lights start at 0 brightness
 }

 // --- We MUST fill in these abstract methods from SmartDevice ---
 @Override // Good practice to say we're fulfilling a promise from the parent
 public void turnOn() {
     isOn = true;
     brightness = 80; // Lights turn on to 80% brightness by default
     System.out.println(name + " Light: Turned ON. (Bright: " + brightness + "%)");
 }

 @Override
 public void turnOff() {
     isOn = false;
     brightness = 0;
     System.out.println(name + " Light: Turned OFF.");
 }

 // --- We MUST fill in this method from the Dimmable interface ---
 @Override
 public void dim(int level) {
     if (isOn) { // Only dim if the light is on!
         if (level >= 0 && level <= 100) {
             this.brightness = level;
             System.out.println(name + " Light: Brightness set to " + brightness + "%.");
         } else {
             System.out.println(name + " Light: Invalid brightness. Must be 0-100.");
         }
     } else {
         System.out.println(name + " Light is off. Turn on to dim.");
     }
 }
}