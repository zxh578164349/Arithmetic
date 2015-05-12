import java.util.Scanner;


public class Arithmetic {
	/**
	 * 猴子吃桃：有一堆桃子，第一天，猴子吃了一半，又多吃一個；
	 * 第二天，吃了半，又多吃一個；
	 * 第三天，.......
	 * 第十天，只剩下一個，問這堆桃子一共有多少個？
	 * 分析：f(1)=1;f(2)=(f(3)-f(3)/2)-1,也就是，2f(2)=f(3)-2,f(3)=2f(2)+2=2(f(2)+1)
	 * f(3)=2(f(2)+1),由此得出：f(n)=2(f(n-1)+1)
	 * @return
	 */
	public static void monkeyEatPeach(int days){		
		int result=1;
		for(int i=1;i<days;i++){
			result=2*(result+1);
			System.out.println("第"+i+"天剩下："+result);
		}
	}
	/**
	 * 求最大公约数与最小公倍数
	 * 最大公约数：用"辗转相除法"，a%b，（前提：a大于b）
	 * 如果，a%b==0,则最大公约数为b,否则，继续用b%(a%b),(前提，b>(a%b))
	 * 如果，b%(a%b)==0，则最大公约数为a%b,否则，继续(a%b)%(b%(a%b)),一直两者取模为0
	 * 
	 * 最小公倍数：a*b/最大公约数
	 * @param args
	 */
	public static int getMaxNum(int a,int b){
		/**
		 * 最大公约数
		 */
		//判断a,b大小
		if(a<b){
			/*int temp=a;
			a=b;
			b=temp;*/
			a=a-b;
			b=a+b;
			a=b-a;					
		}
		while(a%b!=0){
			a=a%b;		
			//判断a,b大小
			if(a<b){				
				a=a-b;
				b=a+b;
				a=b-a;					
			}		
		}
		return b;		
	}
	public static int getMinNum(int a,int b){
		/**
		 * 最小公倍数
		 */
		return a*b/getMaxNum(a,b);
	}
	/**
	 * 两个数对换
	 */
	public static void changeNum(int a,int b){
		//判断a,b大小
				if(a<b){
					/*int temp=a;
					a=b;
					b=temp;*/
					//或者
					/*
					 * a=a-b;
					 * b=a+b;
					 * a=b-a
					 */
					a=a+b;
					b=a-b;
					a=a-b;
					System.out.print("Max:"+a+"\t");
					System.out.print("Min:"+b+"\t");
				}				
	}
	public static void main(String[] args) {
		/*Scanner input=new Scanner(System.in);
		System.out.print("請輸入天數：");
		monkeyEatPeach(input.nextInt());*/
		changeNum(5,6);
		
		
	}
	
}
