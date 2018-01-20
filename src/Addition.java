public class Addition
{
    public boolean checkIfSum(String firstNumber, String secondNumber)
    {
        boolean flag = false;
        if (firstNumber.length() != secondNumber.length())
        {
            flag = false;
        }
        if(firstNumber.equals(secondNumber))
        {
            flag = true;
        }
        return flag;
    }

    public String sumOfNumbers(String firstNumber, String secondNumber)
    {
        int carryOver = 0;
        int sumOfDigits = 0;
        int i = firstNumber.length();
        int j = secondNumber.length();
        int length = i;
        StringBuilder temporary = new StringBuilder();
        if(i>j)
        {
            length = j;
        }
        for(int k = 1; k<=length; k++)
        {
            sumOfDigits = Integer.parseInt(Character.toString(firstNumber.charAt(--i))) + Integer.parseInt(Character.toString(secondNumber.charAt(--j))) + carryOver;
            carryOver = sumOfDigits/10;
            temporary.insert(0,sumOfDigits%10);
        }
        while(i > 0)
        {
            sumOfDigits = Integer.parseInt(Character.toString(firstNumber.charAt(--i))) + carryOver;
            carryOver = sumOfDigits/10;
            temporary.insert(0, sumOfDigits % 10);
        }
        while(j > 0)
        {
            sumOfDigits = Integer.parseInt(Character.toString(secondNumber.charAt(--j))) + carryOver;
            carryOver = sumOfDigits/10;
            temporary.insert(0, sumOfDigits % 10);
        }
        if(carryOver != 0)
        {
            temporary.insert(0, carryOver);
        }
        return temporary.toString();
    }
}