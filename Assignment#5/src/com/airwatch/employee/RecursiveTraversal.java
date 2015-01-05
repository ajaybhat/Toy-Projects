package com.airwatch.employee;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ABhat on 14 Aug 2014 - 14/08/14.
 */
public class RecursiveTraversal {

    public static void main(String[] args) {
        String top = "E://";
        RecursiveTraversal recursiveTraversal = new RecursiveTraversal();
        String fileToFind = args[0];
        fileToFind = fileToFind.replaceAll("%20%", " ");
        recursiveTraversal.findFile(args[0], top);
    }

    private void findFile(String filename, String parent) {
        FileWalker walker = new FileWalker(filename);
        Path startingDir = Paths.get(parent);
        try {
            Files.walkFileTree(startingDir, walker);
        } catch (AccessDeniedException e) {
            System.out.println("Access denied.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (walker.fileFound)
            System.out.println(walker.getFilePath());
        else System.out.println("File not found.");
    }
}

class FileWalker extends SimpleFileVisitor<Path> {
    String fileToFind;
    boolean fileFound = false;
    String filePath = null;


    FileWalker(String find) {
        fileToFind = find;
    }

    public boolean isFileFound() {
        return fileFound;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Visit failed for file : " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Visiting : " + file.toString());
        if (!attrs.isDirectory() && file.toFile().getName().equalsIgnoreCase(fileToFind)) {
            fileFound = true;
            filePath = file.toAbsolutePath().toString();
            System.out.println("File found.");
            return FileVisitResult.TERMINATE;
        }
        return FileVisitResult.CONTINUE;
    }
}

/*
Connected to the target VM, address: '127.0.0.1:60526', transport: 'socket'
Visit failed for file : E:\$RECYCLE.BIN\S-1-5-21-1343775339-305583258-3706297141-1000
Visit failed for file : E:\$RECYCLE.BIN\S-1-5-21-1343775339-305583258-3706297141-500
Visiting : E:\$RECYCLE.BIN\S-1-5-21-1873924715-1625612713-2599817624-33586\desktop.ini
Visiting : E:\Airwatch Training\1. Fundamentals of Web Applications.pdf
Visiting : E:\Airwatch Training\2. Enterprise Systems.pdf
Visiting : E:\Airwatch Training\3. Networking Fundamentals.pdf
Visiting : E:\Airwatch Training\4. Data Base Management Systems.pdf
Visiting : E:\Airwatch Training\5. Digital Certificates.pdf
Visiting : E:\Airwatch Training\6. New Hire Training Tool Kit.pdf
Visiting : E:\Airwatch Training\MDM Guides\AirWatch ACC On-Premise Installation Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\AirWatch ACC SaaS Installation Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\AirWatch App Wrapping Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\AirWatch MAG Install Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\Mobile Application Management Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\Mobile Content Management Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\Mobile Device Management Guide v7_2.pdf
Visiting : E:\Airwatch Training\MDM Guides\Mobile Email Management Guide v7_2.pdf
..........................
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\Car.class
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\Car.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\Driver.class
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\Driver.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\FourWheeler.class
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\FourWheeler.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\ReflectionTest.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\TwoWheeler.class
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\automobile\TwoWheeler.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\employee\Developer.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\employee\Employee.java
Visiting : E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\employee\EmployeeTest.java
File found.
E:\Java Training\IntelliJ Projects\Java_Assignment #3\src\com\airwatch\employee\EmployeeTest.java
 */