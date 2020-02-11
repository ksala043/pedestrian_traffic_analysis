/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahelps.sparkdev;

import java.util.*;
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
    String nodeLetter;
    String sessionNum;
    Scanner userInput = new Scanner(System.in); //global variable so other methods can use it
	
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
        String fileName;
        String ans;
        
        do{
            System.out.println("Enter file name: ");
            fileName = userInput.nextLine();
            
            System.out.println(fileName); 
            /*
            Add code to open pcap file and output in correct format to txt
            */
            
            PcapHandle handle;
            try {
                handle = Pcaps.openOffline(fileName, TimestampPrecision.NANO);
            } catch (PcapNativeException e) {
                handle = Pcaps.openOffline(fileName);
            }
            
            //Needs to be in for loop - how do we get the # of packets in pcap file
                try {
                    Packet packet = handle.getNextPacketEx();
                    //System.out.println(handle.getTimestamp());
                    System.out.println(packet);
                } catch (TimeoutException e) {
                } catch (EOFException e) {
                    System.out.println("EOF");
                    break;
                }
            
            /* Print out only the source IP addresses of each packet */

            System.out.println("Do you want to open another file? y/n");
            ans = userInput.next();
            userInput.nextLine();
            
        } while (ans.equals("y"));
    }
    //--------------------------------------------------------------------------
}
