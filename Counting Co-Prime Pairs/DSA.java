
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DSA {
    private final static int MAX=(int) 1e6; 
    public static long coPrimes(int[] nums){
        long[] count=new long[MAX+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=1;i<MAX+1;i++){
            for(int j=2*i;j<MAX+1;j+=i){
                count[i]+=count[j];
            }
        }
        for(int i=1;i<MAX+1;i++){
            count[i]=count[i]*(count[i]-1)/2;
        }
        for(int i=MAX;i>0;i--){
            for(int j=2*i;j<MAX+1;j+=i){
                count[i]-=count[j];
            }
        }
        return count[1];
    }
    public static void main(String[] args) throws IOException{
        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(st.nextToken());
            }
            long res=coPrimes(nums);
            System.out.println(res);
        }
    }
}
