package com.company.entity;

public class PopulationItems implements Comparable<PopulationItems> {

    public int getScore() {
        return score;
    }

    public String getBinaryScoreScore() {
        return Integer.toBinaryString(score+ 0b100000000).substring(1);
    }

    public int getAssessmentOfAdaptation() {
        return 2*(score*score+1);
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public PopulationItems(int populationScore) {
        score = populationScore;
    }

    @Override
    public int compareTo(PopulationItems o) {
        if(this.getAssessmentOfAdaptation()<o.getAssessmentOfAdaptation())
            return -1;
        else if(o.getAssessmentOfAdaptation()<this.getAssessmentOfAdaptation())
            return 1;
        return 0;
        }
}
