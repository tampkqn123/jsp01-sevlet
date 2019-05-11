import java.util.Scanner;

public class Menu {
	public static void main(String args[]) throws Exception{
		int n=-1;
		Scanner scan= new Scanner(System.in);
		do {
			System.out.println("\n1.Quan ly sach");
			System.out.println("2.Quan ly Danh Muc");
			System.out.println("3.Quan ly Nhan vien");
			System.out.println("0.Exit");
			n=scan.nextInt();
			if(n==1) {
				TestBookSQL.main(args);
			}
			if(n==2) {
				TestCategorySql.main(args);
			}
			if(n==3) {
				TestEmployeeSQL.main(args);
			}
		}while(n!=0);
	}
}
