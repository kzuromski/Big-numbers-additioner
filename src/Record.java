import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Record
{
    private String firstNumber;
    private String secondNumber;
    private String resultNumber;

    public String getFirstNumber()
    {
        return firstNumber;
    }

    public String getSecondNumber()
    {
        return secondNumber;
    }

    public String getResultNumber()
    {
        return resultNumber;
    }

    public List<Integer> getNumberAsDigits(String number)
    {
        Pattern pattern = Pattern.compile("");
        List<Integer> numberAsDigits = pattern.splitAsStream(number).map(Integer::valueOf).collect(Collectors.toList());

        return numberAsDigits;
    }

    public void fillDiffrence(List<Integer> temporary, List<Integer> resultNumber)
    {
        int diffrence = 0;
        if(resultNumber.size() >= temporary.size())
        {
            diffrence = resultNumber.size() - temporary.size();
            for(int i=0; i < diffrence; i++)
            {
                temporary.add(0, 0);
            }
        }
        else
        {
            diffrence = temporary.size() - resultNumber.size();
            for(int i=0; i < diffrence; i++)
            {
                resultNumber.add(0, 0);
            }
        }
    }

    public boolean checkIfSum(List<Integer> temporary, List<Integer> resultNumber)
    {
        fillDiffrence(temporary, resultNumber);
        boolean flag = false;
        Collections.reverse(resultNumber);
        for(int i=temporary.size() - 1; i >= 0; i--)
        {
            if(temporary.get(i) == resultNumber.get(i))
            {
                flag = true;
            }
            else
            {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public List<Integer> sumOfNumbers(List<Integer> firstNumber, List<Integer> secondNumber)
    {
        fillDiffrence(firstNumber, secondNumber);
        int length = firstNumber.size();
        int carryOver = 0;
        int sumOfDigits = 0;
        List<Integer> temporary = new ArrayList<>();
        for(int i = length - 1; i >= 0; i--)
        {
               sumOfDigits = firstNumber.get(i) + secondNumber.get(i) + carryOver;
               if(sumOfDigits >= 10)
               {
                   temporary.add(sumOfDigits % 10);
                   carryOver = sumOfDigits / 10;
               }
               else
               {
                   temporary.add(sumOfDigits);
                   carryOver = 0;
               }
        }
        if(carryOver != 0)
        {
            temporary.add(length, carryOver);
        }
        return temporary;
    }
}
