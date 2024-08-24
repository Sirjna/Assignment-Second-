package displayevennumbers;

public class DisplayEvenNumbers {

    public static void main(String args[])   
    {  
        int n = 100;  
        System.out.print("List of even numbers from 1 to 100: \n");  
        
        for (int i = 1; i <= n; i++)   
        { 
            if (i % 2 == 0)
            {
                System.out.print(i + " ");
            }
        }
    }  
}