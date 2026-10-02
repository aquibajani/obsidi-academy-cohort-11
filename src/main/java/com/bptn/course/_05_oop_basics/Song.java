package com.bptn.course._05_oop_basics;

public class Song {

	  static void chorus(){
	    System.out.println("I'm looking over a four-leaf clover");
	    System.out.println("That I overlooked before");
	  }	

	  public static void main(String args[]) {
	    Song.chorus();
	    System.out.println("One leaf is sunshine, the second is rain");
	    System.out.println("Third is the roses that grow in the lane");
	    System.out.println();
	    System.out.println("No need explaining, the one remaining");
	    System.out.println("Is somebody I adore");
	    Song.chorus();
	  }
}