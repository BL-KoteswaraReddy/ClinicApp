package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Doctor {
    private String id;
    private String name;
    private Specialization specialization;
    private int experience;
    private Shift shift;

    private ArrayList<String>  bookedSlots = new ArrayList<>();


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public Shift getShift() {
        return shift;
    }

    public Doctor(String id, String name, Specialization specialization, int experience, Shift shift) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience='" + experience + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }

   public boolean isSlotFree(String requestTime)
    {
        return !bookedSlots.contains(requestTime);
    }

    public void bookSlot(String requestTime)
    {
        bookedSlots.add(requestTime);
    }


    public boolean isShiftCompatability(String shift)
    {
        return shift.equalsIgnoreCase(getShift().toString());
    }


}
