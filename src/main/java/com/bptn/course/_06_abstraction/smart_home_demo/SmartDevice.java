package com.bptn.course._06_abstraction.smart_home_demo;

//SmartDevice.java - Our partially built blueprint!
public abstract class SmartDevice {
 String name;    // Every device has a name
 boolean isOn;   // Every device knows if it's on or off

 // Constructor: How we create a basic SmartDevice
 public SmartDevice(String name) {
     this.name = name;
     this.isOn = false; // By default, all devices start OFF
 }

 // A concrete method: All SmartDevices can do this in the same way
 public void displayStatus() {
     System.out.println(name + " is " + (isOn ? "ON" : "OFF"));
 }

 // Abstract methods: These MUST be filled in by any specific device class!
 // We declare them, but don't implement them here.
 public abstract void turnOn();
 public abstract void turnOff();
}
