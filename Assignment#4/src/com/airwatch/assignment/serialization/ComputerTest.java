package com.airwatch.assignment.serialization;

import java.io.*;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class ComputerTest {

    public static void writeToFile(WindowsComputer computer, int index) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Computer" + index + ".txt"));
            objectOutputStream.writeObject(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WindowsComputer readFromFile(int index) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Computer" + index + ".txt"));
            return (WindowsComputer) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeDetails(WindowsComputer computer, boolean readFromFile) {
        System.out.println("============");
        if (readFromFile) System.out.println("Persistent");
        System.out.println("Processor Cores : " + computer.getNumProcessorCores() + "\nDisk Space : " + computer.getDiskSpaceInGB() + "\nRam in GB : " + computer.ramInGB());
        System.out.println("Windows Version : " + computer.getWindowsVersion() + "\nArchitecture : " + computer.getArchitecture() + "\nOS Vendor : " + computer.OS_VENDOR);
     //   System.out.println(computer.get);
    }

    public static void main(String[] args) {
        WindowsComputer computer1 = new WindowsComputer();
        WindowsComputer computer2 = new WindowsComputer();
        WindowsComputer computer3 = new WindowsComputer();

        computer1.setArchitecture("32 bit");
        computer1.setWindowsVersion("7");
        computer1.setDiskSpaceInGB(540);
        computer1.setProcessorCores(4);
        computer1.setRamInGB(2048);
        computer1.OS_VENDOR="Microsoft Corporation";

        computer2.setArchitecture("64 bit");
        computer2.setWindowsVersion("7");
        computer2.setDiskSpaceInGB(1040);
        computer2.setProcessorCores(8);
        computer2.setRamInGB(8192);
        computer2.OS_VENDOR="Microsoft Corporation";

        computer3.setArchitecture("64 bit");
        computer3.setWindowsVersion("8");
        computer3.setDiskSpaceInGB(540);
        computer3.setProcessorCores(2);
        computer3.setRamInGB(2048);
        computer3.OS_VENDOR="MSFT";

        writeToFile(computer1, 1);
        writeToFile(computer2, 2);
        writeToFile(computer3, 3);

        WindowsComputer readComputer1 = readFromFile(1);
        WindowsComputer readComputer2 = readFromFile(2);
        WindowsComputer readComputer3 = readFromFile(3);

        writeDetails(computer1, false);
        writeDetails(readComputer1, true);
        writeDetails(computer2, false);
        writeDetails(readComputer2, true);
        writeDetails(computer3, false);
        writeDetails(readComputer3, true);


    }
}
