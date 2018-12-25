import java.util.Scanner;

/**
 * A class to implement the Printer interface to print the numbers(only integers in this case)
 * in the range given by user.
 *
 * The user may input start greater than end, the program will handle that case.
 */
public class NumberPrinter implements Printer
{
    /**
     *
     * @param start the start number
     * @param end the end number
     * @return the numbers in the range of start and end exclusively
     */
    @Override
    public String printNumbers(int start, int end) {
        StringBuilder output = new StringBuilder();

        /* if start is greater than end, swap them*/
        int temp;
        if(start > end)
        {
            temp = start;
            start = end;
            end = temp;
        }

        /* append the numbers in the range to output string*/
        for(int i = start; i < end - 1; i++)
        {
            if((i + 1)%2 != 0)
            output.append((i + 1));
        }

        return output.toString();
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        NumberPrinter numberPrinter = new NumberPrinter();

        /* getting the input from console */
        System.out.println("Enter the start");
        int start = scanner.nextInt();

        System.out.println("Enter the end");
        int end = scanner.nextInt();

        String output = numberPrinter.printNumbers(start, end);
        System.out.println("The numbers in the range of "+start+" and "+end+" are: "+output);

    }
}
