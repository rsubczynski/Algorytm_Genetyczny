package com.company;

import com.company.entity.PopulationItems;

import java.util.ArrayList;
import java.util.Collection;
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
        showPopulationList(populationsList);
        sortPopulationList(populationsList);
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
