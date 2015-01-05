package com.airwatch.assignment.serialization;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class Computer implements ComputerSystem {
    int processorCores;
    int ramInGB;
    int diskSpaceInGB;

    @Override
    public int getNumProcessorCores() {
        return processorCores;
    }

    @Override
    public int ramInGB() {
        return ramInGB;
    }

    public void setProcessorCores(int processorCores) {
        this.processorCores = processorCores;
    }

    public void setRamInGB(int ramInGB) {
        this.ramInGB = ramInGB;
    }

    public int getDiskSpaceInGB() {
        return diskSpaceInGB;
    }

    public void setDiskSpaceInGB(int diskSpaceInGB) {
        this.diskSpaceInGB = diskSpaceInGB;
    }

}
