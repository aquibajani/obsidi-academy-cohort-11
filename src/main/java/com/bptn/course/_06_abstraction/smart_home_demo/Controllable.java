package com.bptn.course._06_abstraction.smart_home_demo;

//Controllable.java - The "Can Change Settings" contract
public interface Controllable {
 void changeSetting(String settingName, String value); // Anyone implementing this MUST provide this method
}