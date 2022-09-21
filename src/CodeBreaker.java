import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CodeBreaker
{
    public static void main(String[] args)
    {
        File name = new File("/Users/krishnan/Downloads/Java Files/12th Grade/CodeBreaker/src/code.txt");
        String solution = "";
        List<String> guesses = new ArrayList<>();
        int count = 0;

        try
        {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;

            while ((text = input.readLine()) != null)
            {
                if(count == 0)
                {
                    solution = text;
                }
                else
                {
                    guesses.add(text);
                }
                count++;
            }
        }

        catch (Exception e)
        {

        }


        for(int i = 0; i < guesses.size(); i++)
        {
            System.out.println("Code: " + solution);

            //adding each character in guess to list
            List<Character> guessChars = new ArrayList<>();
            for(int u = 0; u < 4; u++)
            {
                guessChars.add(guesses.get(i).charAt(u));
            }

            //adding each character in solution to list
            List<Character> solutionChars = new ArrayList<>();
            for(int m = 0; m < 4; m++)
            {
                solutionChars.add(solution.charAt(m));
            }

            int correctColor = 0;
            int correctColorPlace = 0;

            //checking for color + position matches
            for(int x = 0; x < 4; x++)
            {
                if(guessChars.get(x) == solutionChars.get(x))
                {
                    correctColorPlace++;
                    guessChars.set(x,' ');
                    solutionChars.set(x,' ');
                }
            }

            //checking for only color matches
            for(int y = 0; y < 4; y++)
            {
                for(int z = 0; z < 4; z++)
                {
                    if(guessChars.get(y) != ' ')
                    {
                        if(solutionChars.get(z) != ' ')
                        {
                            if(guessChars.get(y) == solutionChars.get(z))
                            {
                                correctColor++;
                                guessChars.set(y,' ');
                                solutionChars.set(z,' ');
                            }
                        }
                    }
                }
            }

            System.out.println("Guess: " + guesses.get(i));
            System.out.println("Color Correct - Correctly Placed: " + correctColorPlace);
            System.out.println("Color Correct - Incorrectly Placed: " + correctColor);
            System.out.println();
        }
    }
}