
/**
 * @author Rishabh Agarwal
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
import java.util.Scanner;

public class Solution {
    
    public static int find(int a[],int low, int high,int k){
        while(low<high){
            int mid = low + ((high-low)/2);
            if(a[mid]<k){
                low = mid+1;
            }
           
            else{
                high = mid;
            }
        }
        return high;
    }
    
    public static void lics(int arr[]){
        int len = 0,temp = 0;;
        int a[] = new int[arr.length];
        a[0] = arr[0];
        len++;
        for(int i = 1;i<a.length;i++){
            if(a[len-1]<arr[i]){
                a[len] = arr[i];
                len++;
            }
            else{
                if(arr[i]<a[0]){
                    a[0] = arr[i];
                }
                else{
                    temp = find(a,0,len-1,arr[i]);
                    a[temp] = arr[i];

                }
                
            }
        }
        System.out.println(len);
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int i = 0;
        while(i<n){
            a[i] = in.nextInt();
            i++;
        }
        lics(a);
    }
}