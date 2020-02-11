/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahelps.sparkdev;

import java.util.*;

/**
 *
 * @author Shaneka Lewis
 */
public class pcapTools {
    String nodeLetter;
    String sessionNum;
    Scanner userInput = new Scanner(System.in); //global variable so other methods can use it
	
    pcapTools() {
        nodeLetter = "Z";
	sessionNum = "1";
    }
	
    pcapTools(String nodeLetter, String sessionNum) {
        this.nodeLetter = nodeLetter;
        this.sessionNum = sessionNum;	
    }

    public void setNodeLetter(String nodeLetter) {
        this.nodeLetter = nodeLetter;
    }

    public void setSessionNum(String sessionNum) {
        this.sessionNum = sessionNum;
    }
    
    //--------------------------------------------------------------------------
    public void getUniqueIPs() {
        String fileName;
        String ans;
        
        do{
            System.out.println("Enter file name: ");
            fileName = userInput.nextLine();
            
            System.out.println(fileName); 
            
            /*
            Add code to open pcap file and output in correct format to txt
            */
            
            
            System.out.println("Do you want to open another file? y/n");
            ans = userInput.next();
            userInput.nextLine();
            
        } while (ans.equals("y"));
    }
    //--------------------------------------------------------------------------
}
