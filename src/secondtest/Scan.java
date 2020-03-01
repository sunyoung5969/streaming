package secondtest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
	int scanInt() {
		int inputNum = 0;
		int state = 0;
		while (state != -1) {
			try {
				Scanner scan = new Scanner(System.in);
				inputNum = scan.nextInt();
				state = -1;
			} catch (InputMismatchException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				state = 0;

			}
		}
		return inputNum;
	}

	String scanStr() {
		String inputStr = "";
		int state = 0;

		while (state != -1) {
			try {
				Scanner scan = new Scanner(System.in);
				inputStr = scan.next();
				state = -1;
			} catch (InputMismatchException e) {
				System.out.println("�� �� �Է��ϼ̽��ϴ�.");
				state = 0;
			}
		}
		return inputStr;
	}
}
