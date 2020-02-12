/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahelps.sparkdev;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;

/**
 *
 * @author Shaneka Lewis
 */
public class main {
    public static void main(String[] args) throws PcapNativeException, NotOpenException {
        pcapTools test = new pcapTools();
        /*an object of type pcaptools is created 
        with the default parameters*/
        test.getUniqueIPs();
    }
}
