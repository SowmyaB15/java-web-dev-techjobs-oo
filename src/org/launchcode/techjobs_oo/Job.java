package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {

        if (name.equals("") && employer.getValue().equals("") && location.getValue().equals("") &&
                positionType.getValue().equals("") && coreCompetency.getValue().equals("")) {
            return "OOPS! This job does not seem to exist.";
        }

        if (name.equals("")) { setName("Data not available"); }
        if (employer.getValue().equals("")) { employer.setValue("Data not available"); }
        if (location.getValue().equals("")) { location.setValue("Data not available"); }
        if (positionType.getValue().equals("")) { positionType.setValue("Data not available"); }
        if (coreCompetency.getValue().equals("")) { coreCompetency.setValue("Data not available"); }

        return  "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer + "\n" +
                "Location: " + location + "\n" +
                "Position Type: " + positionType + "\n" +
                "Core Competency: " + coreCompetency +
                "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters

    public int getId() { return id; }

    public String getName() { return name; }

    public Employer getEmployer() { return employer; }

    public Location getLocation() { return location; }

    public PositionType getPositionType() { return positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }

    public void setName(String name) { this.name = name; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public void setLocation(Location location) { this.location = location; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }
}
