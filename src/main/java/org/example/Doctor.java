package org.example;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private int experience;
    private String shift;

    public Doctor(String id, String name, String specialization, int experience, String shift) {
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
}
