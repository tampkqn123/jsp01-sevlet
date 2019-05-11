package Mains;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int n=-1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("1. Quản lý đồ uống!");
			System.out.println("2. Quản lý danh mục!");
			System.out.println("3. Quản lý nhân viên!");
			System.out.println("0. Exit");
			n=scan.nextInt();
			if(n==1) {
				MainDrinks.main(args);
			}
			if(n==2) {
				MainCategory.main(args);
			}
			if(n==3) {
				MainEmployee.main(args);
			}
		}while(n!=0);
	}

}
