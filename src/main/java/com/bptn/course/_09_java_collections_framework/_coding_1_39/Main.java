package com.bptn.course._09_java_collections_framework._coding_1_39;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Student1", 80));
        studentList.add(new Student("Student2", 75));
        studentList.add(new Student("Student3", 86));
        studentList.add(new Student("Student4", 74));
        studentList.add(new Student("Student5", 92));
        studentList.add(new Student("Student6", 72));
        studentList.add(new Student("Student7", 60));

        // initialize passList
        List<Student> passList = new ArrayList<>();
        Iterator<Student> all = studentList.iterator();
        

        // Loop through studentlist to filter the students with target grade
//        for(Student s : studentList) {
//        	if(s.getClassGrade()>=75) {
//        		passList.add(s);
//        		System.out.println(s);
//        	}
//        }
//
//        // print out the students using a for-each loop.     
//        for(Student s : passList) {
//        	
//        }
        
         while(all.hasNext()) {
        	 Student temp = all.next();
        	 if(temp.getClassGrade() >= 75) {
        		 passList.add(temp);
        	 }
         }
         
         Iterator<Student> pass = passList.iterator();
//         System.out.print(passList);
         
         while(pass.hasNext()) {
        	 System.out.println(pass.next());
         }
        
    }
}