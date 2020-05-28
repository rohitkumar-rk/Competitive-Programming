import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //This function is called when a closing bracket is found in string
    static int closingBracketHandler(Character ch, Stack<Character> stack){
        /*On finding any closing bracket, we pop it's respective
        closing bracket. If successfully pops, return 1
        If unable to pop, return 0 */
        if(stack.empty())
            return 0;
        
        Character tos = stack.peek();
        int returnValue = 0;
        if(ch == ')' ){
            if(tos == '('){
                stack.pop();
                returnValue = 1;
            }
        }

        else if( ch == '}'){
            if(tos == '{'){
                stack.pop();
                returnValue = 1;
            }
        }

        else if(ch == ']'){
            if(tos == '['){
                stack.pop();
                returnValue = 1;
            }
        }
        return returnValue;
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));

            else{
                int res = closingBracketHandler(s.charAt(i), stack);
                if(res == 0)
                    return "NO";
            }

        }

        if(stack.empty())
            return "YES";
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
