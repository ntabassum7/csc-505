//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class MatrixMultiplication{
	public static int counter = 0;

	public static int[][] Call_multiplier(int[][] matrix,int power){
		 //Write your code here to call Multiply_matrices lg(power) times.
		 //This method will have the 2-dimensional array and an int which specifies the power as inputs(Please see testcase file)
		 //This method should return the final matrice
		 int i,dim=matrix.length, c=0;
		 int [][] x= new int[dim][dim];
		 int sa[]=new int [100];
		 x=matrix;
		for(;power>1;)
		{
			if(power%2==0)
			{
				sa[c]=2;
				c++;
				power/=2;
			}
			else
			{
				sa[c]=1;
				c++;
				power--;
			}
		}
		for(i=c-1;i>=0;i--)
		{
			if(sa[i]==1)
				x= Multiply_matrices(matrix,x);
			else if(sa[i]==2)
				x= Multiply_matrices(x,x);
		}
		return x;
	}

	public static int[][] Multiply_matrices(int[][] a,int[][] b){
		counter+=1;
		 //Write code here to multiply 2 matrices and return the resultant matrice
		 int i,j,k,dim=a.length;
		 int [][] x= new int[dim][dim];

		 for(i=0;i<dim;i++)
		 	for(j=0;j<dim;j++)
				for(k=0;k<dim;k++)
				 x[i][j]=x[i][j]+a[i][k]*b[k][j];
	 return x;
			
	}
	public static void main(String[] args)
	{
		int[][] matrix = {
			{2,4,3,1},
			{3,1,4,2},
			{4,6,5,3},
			{6,2,4,1}
			};

			int i,j,dim=matrix.length,power=5;
			int [][] mul= new int[dim][dim];
			mul= matrix;


		mul=Call_multiplier(matrix,power);
		for(i=0;i<dim;i++)
		{	for(j=0;j<dim;j++)
			{	
				System.out.println(mul[i][j]);
			}
			System.out.println();
		}
		System.out.println(counter);
	}
}

