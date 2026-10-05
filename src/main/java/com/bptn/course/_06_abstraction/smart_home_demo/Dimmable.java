package com.bptn.course._06_abstraction.smart_home_demo;

//Dimmable.java - The "Can Dim" contract
public interface Dimmable {
 void dim(int level); // Anyone implementing this MUST provide this method (e.g., 0-100%)
}
