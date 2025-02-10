//second largest & smallest number in an array
import java.util.*;


public class q5{
    public static void main(String[] args){
        System.out.print("enter the no of elements in the array: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];

        System.out.println("enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        //corner cases
        if(n==0 || n==1){
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
            
        }

        int small=Integer.MAX_VALUE;
        int second_small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        int second_large=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            small=Math.min(small,arr[i]);  //another way to find smallest element & largest element in an array
            large=Math.max(large,arr[i]);
        }

        for(int i=0;i<n;i++){
            if(second_small>arr[i] && arr[i]!=small){
                second_small=arr[i];
            }
            if(second_large<arr[i] && arr[i]!=large){
                second_large=arr[i];
            }
        }

        System.out.print("2nd large: "+second_large+" "+"2nd small: "+second_small);

    }
}
