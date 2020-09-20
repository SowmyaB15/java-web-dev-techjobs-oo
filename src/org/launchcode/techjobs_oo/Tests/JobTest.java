package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1_empty, job2_empty, job3_allFields, job4_allFieldsSameAsJob3, job5_oneEmptyField, job6_allEmptyFields;

    @Before
    public void createJobObjects() {
        job1_empty = new Job();
        job2_empty = new Job();
        job3_allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4_allFieldsSameAsJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job5_oneEmptyField = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
        job6_allEmptyFields = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2_empty.getId() - job1_empty.getId(), 0.0);
        assertFalse(job1_empty.getId() == job2_empty.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3_allFields.getEmployer() instanceof Employer);
        assertTrue(job3_allFields.getLocation() instanceof Location);
        assertTrue(job3_allFields.getPositionType() instanceof PositionType);
        assertTrue(job3_allFields.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job3_allFields.getName());
        assertEquals("ACME", job3_allFields.getEmployer().getValue());
        assertEquals("Desert", job3_allFields.getLocation().getValue());
        assertEquals("Quality control", job3_allFields.getPositionType().getValue());
        assertEquals("Persistence", job3_allFields.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3_allFields.equals(job4_allFieldsSameAsJob3));
        assertNotEquals(job3_allFields.getId(), job4_allFieldsSameAsJob3.getId());
    }

    @Test
    public void testToStringReturnsBlankLineBeforeAndAfter() {
        assertTrue(job3_allFields.toString().startsWith("\n"));
        assertTrue(job3_allFields.toString().endsWith("\n"));
    }

    @Test
    public void testToStringContainsLabels() {
        assertEquals("\n" +
                "ID: " + job3_allFields.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" +
                "\n", job3_allFields.toString());
    }

    @Test
    public void testToStringForOneEmptyField() {
         assertEquals("\n" +
                 "ID: " + job5_oneEmptyField.getId() + "\n" +
                 "Name: Ice cream taster" + "\n" +
                 "Employer: Data not available" + "\n" +
                 "Location: Home" + "\n" +
                 "Position Type: UX" + "\n" +
                 "Core Competency: Taste" +
                 "\n", job5_oneEmptyField.toString());
    }

    @Test
    public void testToStringForAllEmptyFields() {
        assertEquals("OOPS! This job does not seem to exist.", job6_allEmptyFields.toString());
    }

}

