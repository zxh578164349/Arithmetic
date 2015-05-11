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
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("請輸入天數：");
		monkeyEatPeach(input.nextInt());
	}

}
