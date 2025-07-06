package Innings;

import Match.MatchType;
import Team.Team;

import java.util.ArrayList;
import java.util.List;

public class InningsDetails {
    Team battingTeam;
    Team bowlingTeam;
    List<OverDetails> overDetailsList;
    MatchType matchType;

    public void InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overDetailsList = new ArrayList<>();
    }

}
