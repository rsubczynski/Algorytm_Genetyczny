package com.company;

import com.company.entity.PopulationItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgortymGenetyczny {

    private int populationCount;
    private int sumpaPrzystosowania;
    private ArrayList<PopulationItems> populationsList = new ArrayList<>();
    private ArrayList<PopulationItems> startpopulationsList = new ArrayList<>();


    AlgortymGenetyczny(){
        populationCount = randomNumberInRange(1,100);
        startpopulationsList = createPopulationsList(populationCount);
        populationsList = startpopulationsList;
        getSumaPrzysotsoania(populationsList);
        sortPopulationList(populationsList);
        showPopulationList(populationsList);
        startSelectionChromosome(populationsList);
    }

    private void startSelectionChromosome(ArrayList<PopulationItems> populationsList) {
        PopulationItems populationItems1;
        PopulationItems populationItems2;
        int losowaniePar = populationsList.size()/2;
        for (int i =0;i<losowaniePar;i++) {
            populationItems1 = populationsList.get(randomNumberInRange(0,populationsList.size()-1));
            populationItems2 = populationsList.get(randomNumberInRange(0,populationsList.size()-1));
            krzyzowanie(populationItems1,populationItems2);
            mutacja(populationItems1);
        }

    }

    private void mutacja(PopulationItems populationItems1) {
    }

    private void krzyzowanie(PopulationItems populationItems1, PopulationItems populationItems2) {
        System.out.println("Para Do krzyzowania :");
        System.out.println("1 Osobnik do krzyzowania " +populationItems1.getBinaryScoreScore());
        System.out.println("2 Osobnik do krzyzowania " +populationItems2.getBinaryScoreScore());
        System.out.println("");

        String sufixPref1 = populationItems1.getBinaryScoreScore().substring(0,4);
        String prefixPref1 = populationItems1.getBinaryScoreScore().substring(4,8);
        System.out.println("1 Osobnik do krzyzowania " +sufixPref1 +" : " + prefixPref1);

        String sufixPref2 = populationItems2.getBinaryScoreScore().substring(0,4);
        String prefixPref2 =populationItems2.getBinaryScoreScore().substring(4,8);
        System.out.println("2 Osobnik do krzyzowania " +sufixPref2 +" : " + prefixPref2);

        populationItems1.setScore(Integer.parseInt(sufixPref1+prefixPref2, 2));
        populationItems2.setScore(Integer.parseInt(sufixPref2+prefixPref1, 2));

    }

    private void sortPopulationList(ArrayList<PopulationItems> populationsList) {
        Collections.sort(populationsList);
    }

    private void getSumaPrzysotsoania(ArrayList<PopulationItems> populationsList) {
        for(PopulationItems populationItems : populationsList){
            sumpaPrzystosowania +=populationItems.getAssessmentOfAdaptation();
        }
        System.out.println("Suma przystosowania to : " + sumpaPrzystosowania);
    }

    private int  randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private ArrayList<PopulationItems> createPopulationsList(int populationCount){
        ArrayList<PopulationItems> tempArrayList = new ArrayList<>();
        for(int i = 0 ; i<populationCount ; i++){
            tempArrayList.add(new PopulationItems(randomNumberInRange(1,127)));
        }

        return tempArrayList;
    }

    private void showPopulationList(ArrayList<PopulationItems> populations){
        System.out.println("Wielkosc Listy populacji :" + populations.size());
        for(PopulationItems populationItems : populations){
            System.out.println("Osobnik wynik: "+populationItems.getScore() +
                    " Osobnik wynik w zapis binarny: "+populationItems.getBinaryScoreScore() + " Ocena przystosowania: "
            + (double)populationItems.getAssessmentOfAdaptation()/sumpaPrzystosowania);
        }
    }
}
