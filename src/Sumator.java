import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sumator implements SumatorInterface
{
    public void run(String file)
    {
        Date start = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(dateFormat.format(start));
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        String numbers[];
        String currentLine;
        int numberOfSums = 0;
        int numberOfRows = 0;
        Addition addition = new Addition();
        String temporary;
        boolean tmp;
        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while(null != (currentLine = bufferedReader.readLine()))
            {
                numbers = currentLine.split(";");
                temporary = addition.sumOfNumbers(numbers[0], numbers[1]);
                tmp = addition.checkIfSum(temporary, numbers[2]);
                if(tmp)
                {
                    numberOfSums++;
                }
                numberOfRows++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(null != bufferedReader)
                {
                    bufferedReader.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        Date end = new Date();
        System.out.println(dateFormat.format(end));
        float duration = (float)(end.getTime() - start.getTime())/1000;
        System.out.printf("\nPrzetwarzanie wierszy trwało:%8.2fs. \nPrzetworzono wierszy: %d, w tym sum prawidłowych: %d.", duration, numberOfRows, numberOfSums);
    }
}