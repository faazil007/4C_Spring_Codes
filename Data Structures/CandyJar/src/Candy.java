import java.util.*;
public class Candy
{
    private Stack jar;
    private Stack nonYellowCandies;

    public Candy()
    {
        jar = new Stack();
        nonYellowCandies = new Stack();
    }

    public int removeYellowCandies(String[] candies) {
        int yellowCount = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i].equalsIgnoreCase("Yellow")) {
                yellowCount++;
            } else {
                nonYellowCandies.push(candies[i]);
            }
        }
        return yellowCount;
    }

    public void returnNonYellowCandies()
    {
        while(!nonYellowCandies.isEmpty())
        {
            jar.push(nonYellowCandies.pop());
        }
    }
    public void displayJarContents()
    {
        System.out.println(" Candies in the Jar :: ");
        jar.display();
    }




}
