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

    public void fillDiffrence(List<Integer> firstNumber, List<Integer> secondNumber)
    {
        int diffrence = 0;
        if(firstNumber.size() >= secondNumber.size())
        {
            diffrence = secondNumber.size() - firstNumber.size();
            for(int i=0; i < diffrence; i++)
            {
                firstNumber.add(0, 0);
            }
        }
        else
        {
            diffrence = firstNumber.size() - secondNumber.size();
            for(int i=0; i < diffrence; i++)
            {
                secondNumber.add(0, 0);
            }
        }
    }

    public boolean checkIfSum(List<Integer> firstNumber, List<Integer> secondNumber)
    {
        fillDiffrence(firstNumber, secondNumber);
        boolean flag = false;
        Collections.reverse(secondNumber);
        for(int i = firstNumber.size() - 1; i >= 0; i--)
        {
            if(firstNumber.get(i) == secondNumber.get(i))
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
