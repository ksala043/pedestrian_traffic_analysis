/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahelps.sparkdev;

import java.util.*;

/*Imports needed to use the pcap4j library*/
import java.io.EOFException;
import java.util.concurrent.TimeoutException;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapHandle.TimestampPrecision;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

/**
 *
 * @author Shaneka Lewis
 */
public class pcapTools {
    /*Variables to organize data by node and time of capture*/
    String nodeLetter;
    String sessionNum;
    
    /*Global variable that allows all methods to use this scanner object*/
    Scanner userInput = new Scanner(System.in); 
	
    pcapTools() {
        nodeLetter = "Z";
	sessionNum = "999";
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
    
    //---------------- Currently Working On ---------------------------------
    public void getUniqueIPs() throws PcapNativeException, NotOpenException {
        /*Variable to hold the filepath/filename*/
        String fileName;
        /*Variable to hold user answer*/
        String ans;
        
        /*The do while loop ensure that the code within the loop executes at least once*/
        do{
            System.out.println("Enter file name: ");
            /*To get the entire line of input from user*/
            fileName = userInput.nextLine();
            
            System.out.println(fileName); 
            /*
            Add code to open pcap file and output in correct format to txt
            */
            
            /*The object to open and deal with pcap files*/
            PcapHandle handle;
            try {
                handle = Pcaps.openOffline(fileName, TimestampPrecision.NANO);
            } catch (PcapNativeException e) {
                handle = Pcaps.openOffline(fileName);
            }
            
            //Needs to be in for loop so that it can get all the pcaps in a file
            for (int i = 0; i < 100; i++) {
                try {
                    Packet packet = handle.getNextPacketEx();
                    //System.out.println(handle.getTimestamp());
                    System.out.println(packet);
                } catch (TimeoutException e) {
                } catch (EOFException e) {
                    System.out.println("EOF");
                    break;
                }
            }
            
            /* Task Print out only the source IP addresses of each packet */

            System.out.println("Do you want to open another file? y/n");
            ans = userInput.next();
            userInput.nextLine();
            
        } while (ans.equals("y"));
    }
    //--------------------------------------------------------------------------
    public void displayDestinations(){}

    public void traceIP(String ipAddress) {
	/*Will read the textfiles produced by earlier methods*/
	/*Will ask users which files they would like to look through*/
	/*will note every instance of that address (as source or dest) and the file it was found in*/
	/*will output to textfile to share*/	
    }
	
    public void getPath(String ipAddress) {
	//Will list the order in which an IP address was found in the nodes
	//Will have to differentiate between filenames "nodeA_sessionX" - only look charAt(4)
	//output info		
    }

    public void getPopulation(){
        //Will tally the number of unique IP address at each node and then across all nodes
        //"There were 5 people around node A at noon"
        //"A total of 300 people were gathered by our network at ...."
    }

    public void displayPopulation(){
        //A nicely formated way to display this information and save it 
        //to do a large comparison at the end
    }

    public void getMostTravelled(){}

    public void displayMostTravelled(){}
}
