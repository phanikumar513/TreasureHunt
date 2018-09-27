package d17092018;
import java.util.*;
//7*7 matrix Grid field of 49 Square Field
//
public class TreasureHunt {
	public static void huntBoard(int [][]a)
	{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int dir(int i,int j)
	{
		Random rr=new Random();
		
		int dir=rr.nextInt(3);//Top,Bottom,Left,Right
		System.out.println("Dir="+dir);
		if(i==0)
		{
			while(dir==0)
			{
				dir=rr.nextInt(3);
			}
			return dir;
		}
		else if(i==6)
		{
			while(dir==1)
			{
				dir=rr.nextInt(3);	
			}
			return dir;
		}
		else  if(j==0)
		{
			while(dir==2)
			{
				dir=rr.nextInt(3);	
			}
			return dir;
		} 
		else  if(j==6)
		{
			while(dir==3)
			{
				dir=rr.nextInt(3);	
			}
			return dir;
		} 
		return dir;
	}
	
	public static int dice(int dir,int i)
	{
		Random rr=new Random();
	
		if(dir==0||dir==2)
		{
			int dice=rr.nextInt(i);
			System.out.println("dice="+dice);
			i=dice;
		}
		else if(dir==1||dir==3)
		{
			int dice=rr.nextInt(6-i);
			System.out.println("dice="+dice);
			i=i+dice+1;
		}
		return i;
	}
	
	public static int Rmoney(int a,int d)
	{
		a=a-d;
		return a;
	}
	public static int money(int a,int d)
	{
		a=a+d;
		return a;
	}

	public static boolean isWinner(int i,int j)
	{
		if(i==0||i==6)
		{
			if(j==0||j==6)
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		Random rr=new Random();
		int i,j,winner=0,dice,money=0,Rmoney=0,temp[],count=0;
		int[][]TH= {{100,100,100,100,100,100,100},{100,100,100,100,100,100,100},{100,100,100,100,100,100,100},{100,100,100,000,100,100,100},{100,100,100,100,100,100,100},{100,100,100,100,100,100,100},{100,100,100,100,100,100,100}};
		for(i=0;i<7;i++)
		{
			for(j=0;j<7;j++)
			{
				Rmoney=Rmoney+TH[i][j];
			}
		}
		Rmoney=Rmoney-TH[0][0]-TH[0][6]-TH[6][0];
		i=3;j=3;
		System.out.println("You can won upto "+Rmoney+" money");
		while(winner==0)
		{
			System.out.println();
			System.out.println("\t *TREASURE HUNT BOARD* ");
		//	huntBoard(TH);
	/**/		int dir=dir(i,j);
			switch(dir)
			{
			case 0://Top
				System.out.println("Count="+count);
				i=dice(dir,i);
				System.out.println(i+" "+j);
				if(TH[i][j]==100)
				{
					count++;
					int d=TH[i][j];
					Rmoney=Rmoney(Rmoney,d);
					money=money(money,d);
					TH[i][j]=count;
				}
				else
				{
					System.out.println("Already you visit this place!!");
				}
				huntBoard(TH);
				System.out.println("Money="+money+"\t Required Money="+Rmoney);
				break;
				
			case 1://Bottom
				System.out.println("Count="+count);
				i=dice(dir,i);
				System.out.println(i+" "+j);
				if(TH[i][j]==100)
				{
					count++;
					int d=TH[i][j];
					Rmoney=Rmoney(Rmoney,d);
					money=money(money,d);
					TH[i][j]=count;
				}
				else
				{
					System.out.println("Already you visit this place!!");
				}
				huntBoard(TH);
				System.out.println("Money="+money+"\t Required Money="+Rmoney);
				break;
				
			case 2://Left
				System.out.println("Count="+count);
				j=dice(dir,j);
				System.out.println(i+" "+j);
				if(TH[i][j]==100)
				{
					count++;
					int d=TH[i][j];
					Rmoney=Rmoney(Rmoney,d);
					money=money(money,d);
					TH[i][j]=count;
				}
				else
				{
					System.out.println("Already you visit this place!!");
				}
				huntBoard(TH);
				System.out.println("Money="+money+"\t Required Money="+Rmoney);
				break;
				
			case 3://Right
				System.out.println("Count="+count);
				j=dice(dir,j);
				System.out.println(i+" "+j);
				if(TH[i][j]==100)
				{
					count++;
					int d=TH[i][j];
					Rmoney=Rmoney(Rmoney,d);
					money=money(money,d);
					TH[i][j]=count;
				}
				else
				{
					System.out.println("Already you visit this place!!");
				}
				huntBoard(TH);
				System.out.println("Money="+money+"\t Required Money="+Rmoney);
				break;
	
			}//switch
			
			if(isWinner(i,j))
			{
				winner++;
				System.out.println("End of the game!!");
				System.out.print("You won "+money+" money");
				if(Rmoney!=0)
				{
					System.out.println("\t You lost "+Rmoney+" money");
				}
			}
		}//while
	}

}
