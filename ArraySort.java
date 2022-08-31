import java.lang.UnsupportedOperationException;
import java.util.Scanner;
import java.lang.Integer;

public class ArraySort {
    public static final String MIN_METHOD_NAME = "MIN";
    public static final String MAX_METHOD_NAME = "MAX";
    public static final String RANGE_METHOD_NAME = "RANGE";
    public static final String AVERAGE_METHOD_NAME = "AVERAGE";
    public static final String MODE_METHOD_NAME = "MODE";


//Implement the methods: minWordLength(), maxWordLength(), wordLengthRange(), averageWordLength(), and mostCommonWordLength()
//They should be called in this order from within the main method using the given input array. However, they must return correct results even for different inputs.

	public static int minWordLength(String[] words){
        if (words == null || words.length < 1) {
            return -1;
        }
        String smallestWord = words[0];
        for(int i = 1; i < words.length; i++){
            if(words[i].length() < smallestWord.length()){
                smallestWord = words[i];
            }

        }
        return smallestWord.length();
    }

    public static int maxWordLength(String[] words){
        if (words == null || words.length < 1) {
            return -1;
        }
        String largestWord = words[0];
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > largestWord.length()){
                largestWord = words[i];
            }

        }
        return largestWord.length();
    }

    public static int wordLengthRange(String[] words){
        return maxWordLength(words)- minWordLength(words);
    }

    public static String averageWordLength(String[] words){
        double sum = 0;
        //get the total of all the values
        for (int i =0;i<words.length;i++){
            sum += words[i].length();
        }
        //find the avg of the values
        double average = sum / words.length * 1.0;

        //return the 2 decimal string as the answer
        String ans = String.format("%.2f", average);

        return ans;
    }

    public static int mostCommonWordLength(String[] words){
        int counter[] = new int[101];
        int lengthMax = -1;
        int max = Integer.MIN_VALUE;
        
        //for loop to iterate through the array
        for (int i = 0; i < words.length; i++){
            counter[words[i].length()]++;
            //if statement to determine the max value and the lengthMax value
            if(counter[words[i].length()] > max){
                max = counter[words[i].length()];
                lengthMax = words[i].length();
            }
        }

        //if there is a tie then return -1
        for(int i = 0;i < counter.length;i++){
            if(counter[i] == max){
                if(i != lengthMax)
                    return -1;
            }
        }
        
        //else returns the lengthMax value
        return lengthMax;
    }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your words: ");
        String methodName = sc.nextLine();
        String[] words = methodName.split(","); 
        // Read in number of words
        int numWords = Integer.parseInt(sc.nextLine());
        // Read in list of words
        for (int i = 0; i < numWords; i++) {
            words[i] = sc.nextLine();
        } 
        sc.close();
        // Run the specified method
        switch (methodName) {
            case MIN_METHOD_NAME:
                System.out.println(minWordLength(words));
                break;
            case MAX_METHOD_NAME:
                System.out.println(maxWordLength(words));
                break;
            case RANGE_METHOD_NAME:
                System.out.println(wordLengthRange(words));
                break;
            case AVERAGE_METHOD_NAME:
                System.out.println(averageWordLength(words));
                break;
            case MODE_METHOD_NAME:
                System.out.println(mostCommonWordLength(words));
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

        	

    }
