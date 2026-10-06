package com.bptn.course._07_exception_handling.coding_1_33_custom_exception_logging_data;

import java.util.Scanner;

public class CustomException {
	
	private static void validateFileExtension(String fileName) throws FileExtensionException{
		if(!fileName.endsWith(".txt")){
			throw new FileExtensionException("File doesn't have .txt extension");
		}
	}
	
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the file name with correct extension i.e. .txt ");
    	String fileName = input.nextLine();
        
    	try {
    		validateFileExtension(fileName);
    		System.out.println("Correct file name with extension .txt");	
    	} catch(FileExtensionException e) {
    		System.out.println("Error: " + e.getMessage());
    	} finally {
    		input.close();
    	}
    }
}
