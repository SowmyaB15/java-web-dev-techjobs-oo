package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1, job2;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job2.getId() - job1.getId(), 0.0);
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", test_job.getName());
        assertEquals("ACME", test_job.getEmployer().getValue());
        assertEquals("Desert", test_job.getLocation().getValue());
        assertEquals("Quality control", test_job.getPositionType().getValue());
        assertEquals("Persistence", test_job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test_equal1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_equal2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_equal1.getId() == test_equal2.getId());
    }
}

