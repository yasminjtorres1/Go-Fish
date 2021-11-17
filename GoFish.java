import java.util.ArrayList;
import java.util.Scanner;  

public class GoFish
   {
      public static void main (String [] args)
         {
            Scanner scan = new Scanner(System.in);
            String [] suit = {"Diamond", "Heart", "Spade", "Club"};
            String [] rank = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Jack", "Queen", "King"};
            int [] point = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
            //Declares the deck, hands, and laydown piles
            Deck goFishDeck = new Deck(rank, suit, point);
            ArrayList<Card> pHand = new ArrayList<Card>();
            ArrayList<Card> cHand = new ArrayList<Card>();
            ArrayList<Card> pLaydown = new ArrayList<Card>();
            ArrayList<Card> cLaydown = new ArrayList<Card>();
            //Deals cards
            for (int i = 0; i<5; i++)
               {
                  pHand.add(goFishDeck.deal());
                  cHand.add(goFishDeck.deal());
               }
            //Checks for pairs
            for(int i = 0; i < cHand.size(); i++)
                 {
                    for(int j = 0; j < cHand.size(); j++)
                       {
                         if(cHand.get(i).pointValue() == cHand.get(j).pointValue())
                             {
                                cLaydown.add(cHand.get(i));
                                cLaydown.add(cHand.get(j));
                                cHand.remove(cHand.get(i));
                                cHand.remove(cHand.get(j));
                             }
                       }
                 }
            for(int x = 0; x < pHand.size(); x++)
                 {
                    for(int y = 0; y < pHand.size(); y++)
                       {
                          if(pHand.get(x).pointValue() == pHand.get(y).pointValue())
                             {
                                pLaydown.add(pHand.get(x));
                                pLaydown.add(pHand.get(y));
                                pHand.remove(pHand.get(x));
                                pHand.remove(pHand.get(y));
                             }
                       }
                 }
            //Round counter
            int c = 0;
            while ((pHand.size() > 0) && (cHand.size() > 0))
               {
                  //We will remove the system.outs afterwards it is just there to check
                  System.out.println(pHand);
                  System.out.println(cHand);
                  c++;
                  System.out.println("Round " + c);
                  System.out.println("Player 1's turn ask for a card value.");
                  int reply = scan.nextInt();
 
                  int s = pHand.size();
                  for(int p = 0; p < cHand.size(); p++)
                     {
                           if(reply == cHand.get(p).pointValue())
                              pHand.add(cHand.remove(p));
                     }
                  if (s == pHand.size())
                     {
                        System.out.println("Go fish.");
                        pHand.add(goFishDeck.deal());
                     }
//------------------------------------C O M P U T E R--------B E E P------B O O P-----------------------------------------------------------------------------------------
                  int ran = (int)(Math.random()*cHand.size());
                  Card ranCard = cHand.get(ran);
                  System.out.println("Do you have " + ranCard);
                  
                  for(int i = 0; i < cHand.size(); i ++)
                     {
                   if(cHand.get(i).matches(ranCard))  
                   cLaydown.add(ranCard);  
                     }
                      
                  else
                  {
                  System.out.println("Go fish");
                  cHand.add(goFishDeck.get(0));
                  }
               } 
           //Results need to include laydown piles and declare the winner who has the bigger laydown pile or tie
         }
   
   }	
		