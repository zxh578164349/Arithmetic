import java.util.ArrayList;
import java.util.List;
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
	
	/**
	 * 分解质因数
	 * 例如：8=2*2*2
	 * @param args
	 */
	public static void resolveNum(int num){
		 int temp=num;//临时变量temp，用来保存整除下来的商
		 for(int i=2;i<temp;i++){			 
			 while(temp%i==0){
				 temp=temp/i;//能被整除，则继续while内循环;否则把temp放到for外循环
				 System.out.print(i+"\t");
			 }			 
		 }
		 if(temp!=1){//打印最后一个整除下来的商
			 System.out.print(temp); 
		 }
		 
		
	}
	
	/**
	 * 冒泡算法
	 * 有n个数，进行(n-1)轮，第一轮：调换(n-1)次,第二轮:(n-2)次......,第n轮:(n-i)次
	 * @param args
	 */
	public static void PopPop(){
		int[]nums={9,8,7,6,5,4,3,2,1};
		int length=nums.length;
		for(int i=1;i<=length;i++){
			for(int j=1;j<=length-i;j++){
				if(nums[j-1]>nums[j]){
					int temp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		for(int i=0;i<length;i++){
			System.out.print(nums[i]+"\t");
		}
		
	}
	
	/**
	 * 选择排序法
	 * @param args
	 */
	public static void selectNum(){
		int[]nums={9,7,8,5,6,3,4,2,1};
		//外层交换位置
		for(int i=0;i<nums.length;i++){
			int min=nums[i];
			int index=i;
			int temp=nums[i];
			//内层找出最小数
			for(int j=i+1;j<nums.length;j++){
				if(min>nums[j]){
					min=nums[j];
					index=j;
				}				
			}
			//
			if(index!=i){
				nums[i]=min;
				nums[index]=temp;
			}			
		}
	
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
	}
	
	/**
	 * 插入排序法
	 * n个数，进行(n-1)轮，第1轮:比较1次，第2轮:比较2次......第i轮：比较i次
	 * @param args
	 */
	public static void insertNum(){
		int[]nums={9,8,7,6,5,4,3,2,1};
		for(int i=0;i<nums.length-1;i++){
			for(int j=0;j<i+1;j++){
				//比较时,拿外循环的第(i+1)个数，与内循环的各个数时行比较
				if(nums[i+1]<nums[j]){
					int temp=nums[i+1];
					nums[i+1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"\t");
		}
		
	}
	
	/**
	 *汉诺塔
	 *(1)借助C,把(n-1)个盘从A移动到B;(2)把第n个盘(最大一个盘)移动到C；(3)借助A，把剩余的(n-1)从B移动到C
	 * @param args
	 */
	static int index=0;
	public static int hanNuo(int num,String A,String B,String C){
		if(num==1){
			index++;
			//System.out.println(A+"---"+C);
		}else{
			hanNuo(num-1,A,C,B);
			hanNuo(1,A,B,C);
			hanNuo(num-1,B,A,C);
		}
		return index;
	}
	
	public static void main(String[] args) {
		/*Scanner input=new Scanner(System.in);
		System.out.print("請輸入天數：");
		monkeyEatPeach(input.nextInt());*/
		//resolveNum(100);
		//selectNum();
		//insertNum();
		System.out.print(hanNuo(40,"A","B","C"));
		
		
	}
	
}
