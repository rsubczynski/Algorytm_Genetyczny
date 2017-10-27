package com.company.entity;

public class PopulationItems implements Comparable<PopulationItems> {
    public int getScore() {
        return score;
    }

    public String getBinaryScoreScore() {
        return Integer.toBinaryString(score);
    }

    public int getAssessmentOfAdaptation() {
        return 2*(score*score+1);
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getScoreAsString(){
        return String.valueOf(getAssessmentOfAdaptation());
    }


    private int score;

    public PopulationItems(int populationScore) {
        score = populationScore;
    }

    @Override
    public int compareTo(PopulationItems o) {
            return getScoreAsString().compareTo(o.getScoreAsString());
        }
}
