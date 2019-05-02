package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {



    }
    // Case Problem 3 Amount of two cards that exceed $1,000
    public static void getSellReport(Card[] myCards)
    {
        for (int i = 0; i < myCards.getCount - 1; i++)
        {
            for (int j = i + 1; j < myCards.getCount; j++)
            {
                if(myCards[i].getValue + myCards[j].getValue >= 1000)
                {
                    System.out.println(myCards[i].getPlayer + " " + myCards[j].getPlayer +
                            (myCards[i].getValue + myCards[j].getValue));
                }
            }
        }
    }
    // case problem 1
    public static Card[] readFile()throws IOException
    {
        Card[] myCards = new Card[100];
        Scanner inFile = new Scanner(new File("Card.txt"));

        while(inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] tempArray = tempString.split("#");

            int cardID = Integer.parseInt(tempArray[0]);
            String cardMan = tempArray[1];
            int cardYear = Integer.parseInt(tempArray[2]);
            String cardPlayer = tempArray[3];
            double cardValue = Double.parseDouble(tempArray[4]);

            Card tempCard = new Card(cardID, cardMan, cardYear, cardPlayer, cardValue);
            myCards[Card.getCardCount()] = tempCard;
            Card.setCardCount(Card.getCardCount() + 1);


        }
        inFile.close();
        return myCards;
    }
    //case problem 2
    public static void averageReport(Card[] myCards)
    {
        String cardMan = myCards[0].getCardMan();
        System.out.println(cardMan);
        int totalValue = 0;
        int valueCount = 0;

        for(int i = 0; i < Card.getCount; i++)
        {
            if(myCards[i].getCardMan().equals(cardMan))
            {
                totalValue += myCards[i].getCardValue();
                valueCount++;
            }
            else
            {
                System.out.println(myCards[i - 1].getCardMan() + "Average is: " + (totalValue/valueCount));
                cardMan = myCards[i].getCardMan();
                totalValue = myCards[i].getCardValue;
                valueCount = 1;
            }

        }
        int avg = (totalValue/valueCount);
        System.out.println(cardMan + " Average is " + avg);

    }
    //range and average
    public static void rangeAverage(Card[] myCards)
    {
        double minCardValue = myCards[0].getCardValue();
        double maxCardValue = myCards[0].getCardValue();
        double totalCardValue = myCards[0].getCardValue();

        for(int i = 1; i < card.getCardCount; i++)
        {
            if(myCards[i].getCardValue < minCardValue)
            {
                minCardValue = myCards[i].getCardValue();
            }
            if(myCards[i].getCardValue > maxCardValue)
            {
                maxCardValue = myCards[i].getCardValue();
            }
            totalCardValue += myCards[i].getCardValue();
        }
        double avgCardValue = (totalCardValue/Card.getCardCount);
        double rangeValue = maxCardValue - minCardValue;

        System.out.println("Average is: " + avgCardValue);
        System.out.println("Range is: " + rangeValue);
    }


}
