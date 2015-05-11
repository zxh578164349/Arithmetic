import java.util.Scanner;


public class Arithmetic {
	/**
	 * �U�l�Y��G���@���l�A�Ĥ@�ѡA�U�l�Y�F�@�b�A�S�h�Y�@�ӡF
	 * �ĤG�ѡA�Y�F�b�A�S�h�Y�@�ӡF
	 * �ĤT�ѡA.......
	 * �ĤQ�ѡA�u�ѤU�@�ӡA�ݳo���l�@�@���h�֭ӡH
	 * ���R�Gf(1)=1;f(2)=(f(3)-f(3)/2)-1,�]�N�O�A2f(2)=f(3)-2,f(3)=2f(2)+2=2(f(2)+1)
	 * f(3)=2(f(2)+1),�Ѧ��o�X�Gf(n)=2(f(n-1)+1)
	 * @return
	 */
	public static void monkeyEatPeach(int days){		
		int result=1;
		for(int i=1;i<days;i++){
			result=2*(result+1);
			System.out.println("��"+i+"�ѳѤU�G"+result);
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("�п�J�ѼơG");
		monkeyEatPeach(input.nextInt());
	}

}
