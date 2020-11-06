import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class ITES {
	static long seed;
	static long limit = ( (long)1 << 32 );
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
 		int C = sc.nextInt();
		int A;
		int count;
		int sum;
		int a;
		
		for(int i = 0; i < C; i++)
		{
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			Queue<Integer> list = new LinkedList<Integer>();
			sum = count = 0;
			seed = 1983;
			
			for(int j = 0; j < N; j++)
			{
				A = RNG();
				
				list.add(A);
				
				sum += A;
				
				if(sum > K)
				{		
					while(sum > K)
					{
						a = list.poll();
						sum -= a;
					}
				}
				
				if(sum == K) count++;
			}
			
			System.out.println(count);
		}
		
		sc.close();
	}
	
	public static int RNG ()
	{
		long ret = seed % 10000 + 1;
		
		seed = ( ( seed * 214013 ) + 2531011 ) % limit;
		
		return (int)ret;
	}
}