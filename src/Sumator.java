import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class Sumator implements SumatorInterface
{
    public void run(String file)
    {
        Date start = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(dateFormat.format(start));
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String numbers[] = null;
        try
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while(null != (currentLine = bufferedReader.readLine()))
            {
                numbers = currentLine.split(";");
                Record record = new Record();
                List<Integer> temporary = record.sumOfNumbers(record.getNumberAsDigits(numbers[0]),
                        record.getNumberAsDigits(numbers[1]));
                System.out.println(record.checkIfSum(temporary, record.getNumberAsDigits(numbers[2])));
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
        long duration = end.getTime() - start.getTime();
        System.out.println("Czas trwania przetwarzania pliku: " + duration + " ms");
    }

}
