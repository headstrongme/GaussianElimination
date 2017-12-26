package gaussian;
import java.util.Scanner;
/**
 *
 * @author sarthak
 */
//solve for 3x3 matrix only
public class Gaussian {

  
        double arr [][] = new double [3][4];
        int i=1,j=1,a,b,c;
        
  
  public void printValues()
  {
      System.out.println("");
     for(i=0;i<=2;i++)
        {
            for(j=0;j<=3;j++)
            {
                System.out.print(" "+arr[i][j]);             
            }
            System.out.println("");
        }
  }          
  public void enterValues()
    {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Please enter the values of coefficient of x,y,z and constant for 3 equation ");
        for(i=0;i<=2;i++)
        {
            for(j=0;j<=3;j++)
            {
               arr[i][j]=sobj.nextInt();               
            }
        }
        
       printValues(); 
    }
  //it will swap if arr[i][i] is greater 
  //we basically dont want zero here
  public void swap()
  {
      
      for (int i=0;i<3;i++)                    
        for (int k=i+1;k<3;k++)
            if (Math.abs(arr[i][i])<Math.abs(arr[k][i]))
                for (int j=0;j<=3;j++)
                {
                    double temp=arr[i][j];
                    arr[i][j]=arr[k][j];
                    arr[k][j]=temp;
                }
      pivot1();
  }
  public void pivot1()
  {
      double temp=arr[1][0];
      double temp2=arr[2][0];
    if(arr[0][0]!=0)
    {
        for(i=0;i<=3;i++)
        {
        arr[1][i]=(arr[0][0]*arr[1][i])-(temp*arr[0][i]);
        arr[2][i]=(arr[0][0]*arr[2][i])-(temp2*arr[0][i]);
        }
    }
    System.out.println("");
   pivot2();
    
        
  }
   public void pivot2()
  {
       double temp=arr[0][1];
      double temp2=arr[2][1];
    if(arr[1][1]!=0)
    {
        for(i=0;i<=3;i++)
        {
        arr[0][i]=(arr[1][1]*arr[0][i])-(temp*arr[1][i]);
        arr[2][i]=arr[1][1]*arr[2][i]-temp2*arr[1][i];
        }
    }
     pivot3();   
  }
    public void pivot3()
  {
      double temp=arr[0][2];
      double temp2=arr[1][2];
    if(arr[2][2]!=0)
    {
        for(i=0;i<=3;i++)
        {
        arr[0][i]=arr[2][2]*arr[0][i]-temp*arr[2][i];
        arr[1][i]=arr[2][2]*arr[1][i]-temp2*arr[2][i];
        }
    }
     printValues();   
  }

    public static void main(String[] args) 
    {
        Gaussian g = new Gaussian();      
        g.enterValues();     
        g.swap();
        System.out.println("x="+ (g.arr[0][3]/g.arr[0][0]));
        System.out.println("y="+ (g.arr[1][3]/g.arr[1][1]));
        System.out.println("z="+ (g.arr[2][3]/g.arr[2][2]));
        
    }
    
}
