package com.airwatch.assignment.serialization;

import java.io.Serializable;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class WindowsComputer extends Computer implements Serializable {
    String windowsVersion;
    transient String architecture;
    public static String OS_VENDOR = "Microsoft Corporation";
//    private static final long serialVersionUID = 1L;

    public String getWindowsVersion() {
        return windowsVersion;
    }

    public void setWindowsVersion(String windowsVersion) {
        this.windowsVersion = windowsVersion;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public static String getOS_VENDOR() {
        return OS_VENDOR;
    }

    public static void setOS_VENDOR(String OS_VENDOR) {
        WindowsComputer.OS_VENDOR = OS_VENDOR;
    }
}
