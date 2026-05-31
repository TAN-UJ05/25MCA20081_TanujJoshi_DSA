import java.util.Scanner;
 
public class DSA {
    final static int MAX=(int) (2*1e6);
    final static long MOD=(long) (1e9+7);
    final static long[] FACT=new long[(int) (MAX+1)];
 
    public static void precompute(){
        FACT[0]=1;
        for(int i=1;i<FACT.length;i++) FACT[i]=(i*FACT[i-1])%MOD;
    }
 
    public static long pow(long a, long b){
        if(b==0) return 1;
        long x=pow(a,b/2);
        x=(x*x)%MOD;
        if(b%2!=0) x=(x*a)%MOD;
        return x;
    }
 
    public static long modInv(long r){
        return pow(r,MOD-2)%MOD;
    }
 
    public static long ncr(long n, long r){
        if(n<r || r<0) return 0;
        return ((FACT[(int) n]*modInv(FACT[(int) (n-r)]))%MOD*modInv(FACT[(int) r]))%MOD;
    }
 
    public static long median(int[] a, int k){
        long sum=0;
        int ones=0;
        for(int i=0;i<a.length;i++) if(a[i]==1) ones++;
        int zeros=a.length-ones;
        for(int i=(k/2)+1;i<=k;i++) sum=(sum+(ncr(ones,i)*ncr(zeros,k-i))%MOD)%MOD;
        return sum;
    }
    
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int t=sc.nextInt();
            long[] res=new long[t];
            precompute();
            for(int i=0;i<t;i++){
                int n=sc.nextInt();
                int k=sc.nextInt();
                int[] nums=new int[n];
                for(int j=0;j<n;j++) nums[j]=sc.nextInt();
                long ans=median(nums,k);
                res[i]=ans;
            }
            for(long i: res) System.out.println(i);
        }   
    }
}
