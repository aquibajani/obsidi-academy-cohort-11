package com.bptn.course._09_java_collections_framework;

import java.util.LinkedList;

public class BrowserHistoryManager {
    public static void main(String[] args) {
        // 1. Create a LinkedList for history
    	LinkedList<String> history = new LinkedList<>();
    			
        // 2. Visit Pages (Add to end/tail)
    	history.addLast("www.obsidi.com");
    	history.addLast("www.bfutr.com");
    	history.addLast("www.google.com");
    	history.addLast("www.apple.com");
    	
        // 3. Go Back (Remove Last/Tail)
    	history.removeLast();

        // 4. Visit a New Page
    	history.addLast("www.linkedin.com");

        // 5. View Current History
    	System.out.println(history);

    }
}

