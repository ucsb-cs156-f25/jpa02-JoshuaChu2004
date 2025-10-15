package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert (team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value() {

        int testSuccess = 0;

        Team team1 = new Team("test-team1");
        Team team2 = new Team("test-team2");

        Application app1 = new Application();

        team1.addMember("member1");
        team2.addMember("member2");

        assertEquals(false, team1.equals(team2));

        team2.setMembers(new ArrayList<>());
        team2.addMember("member1");

        assertEquals(false, team1.equals(team2));

        team2.setName("test-team1");
        team2.addMember("member3");

        assertEquals(false, team1.equals(team2));

        team2.setMembers(team1.getMembers());

        assertEquals(true, team1.equals(team2));

        team2 = team1;

        assertEquals(true, team1.equals(team1));
        assertEquals(false, team1.equals(app1));

    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        assertEquals(130294, t1.hashCode());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
