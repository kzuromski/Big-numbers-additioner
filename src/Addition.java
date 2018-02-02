public class Addition
{
    public boolean sumOfNumbers(String firstNumber, String secondNumber, String thirdNumber)
    {
        boolean flag = false;
        int carryOver = 0;
        int sumOfDigits;
        int i = firstNumber.length();
        int j = secondNumber.length();
        int length = i;
        int numberOfDigitsDifference = thirdNumber.length() - j;
        int o = thirdNumber.length();
        StringBuilder temporary = new StringBuilder();
        if (i > j)
        {
            length = j;
            numberOfDigitsDifference = thirdNumber.length() - i;
        }
        if(numberOfDigitsDifference == 1 || numberOfDigitsDifference == 0)
        {
            flag = true;
            for (int k = 1; k <= length; k++)
            {
                sumOfDigits = Integer.parseInt(Character.toString(firstNumber.charAt(--i))) + Integer.parseInt(Character.toString(secondNumber.charAt(--j))) + carryOver;
                carryOver = sumOfDigits / 10;
                temporary.insert(0, sumOfDigits % 10);
                if(temporary.charAt(0) != thirdNumber.charAt(--o))
                {
                    return false;
                }
            }
            while (i > 0)
            {
                sumOfDigits = Integer.parseInt(Character.toString(firstNumber.charAt(--i))) + carryOver;
                carryOver = sumOfDigits / 10;
                temporary.insert(0, sumOfDigits % 10);
                if(temporary.charAt(0) != thirdNumber.charAt(--o))
                {
                    return false;
                }
            }
            while (j > 0)
            {
                sumOfDigits = Integer.parseInt(Character.toString(secondNumber.charAt(--j))) + carryOver;
                carryOver = sumOfDigits / 10;
                temporary.insert(0, sumOfDigits % 10);
                if(temporary.charAt(0) != thirdNumber.charAt(--o))
                {
                    return false;
                }
            }
            if (carryOver != 0)
            {
                temporary.insert(0, carryOver);
            }
        }
        return flag;
    }
}
