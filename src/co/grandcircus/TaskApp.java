package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Task T1 = new Task("chris", "lab", "12/12/2012", false, 1);
		String name;
		String descript;
		String date;
		int delete;
		boolean due = false;
		int num = 0;
		boolean check = true;

		ArrayList<Task> taskList = new ArrayList<Task>();
		while (check) {
			System.out.println(
					"1. List tasks \n2. Add Tasks \n3. Delete Task \n4. Mark Task Complete \n5. Quit \nWhat would you like to do?");
			int choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				System.out.println("List Tasks");
				for (int i = 0; i < taskList.size(); i++) {
					System.out.println(taskList.get(i));
				}
				check = true;
				System.out.println("");
				break;

			case 2:

				System.out.println("Add Task \nName");
				name = nameValidation(scan);
				System.out.println("Description");
				descript = scan.nextLine();
				System.out.println("Due Date");
				date = dateValidation(scan);
				num++;
				taskList.add(new Task(name, descript, date, due, num));
				check = true;
				System.out.println("");
				break;
			case 3:

				for (int i = 0; i < taskList.size(); i++) {
					System.out.println(taskList.get(i));
				}

				taskList.remove((Validator.getInt(scan, "Which task would you like to delete select a number: ", 0,
						taskList.size())) - 1);
				int num2 = 0;
				for (int i = 0; i < taskList.size(); i++) {
					num2++;
					taskList.get(i).setNum(num2);
				}
				System.out.println("");
				check = true;
				break;
			case 4:
				for (int i = 0; i < taskList.size(); i++) {
					System.out.println(taskList.get(i));
				}

				taskList.get((Validator.getInt(scan, "Which task did you complete? ", 0, taskList.size())) - 1)
						.setDue1(true);
				System.out.println("");
				check = true;
				break;
			case 5:
				String s = Validator.getString(scan, "Are you sure you want to quit? y/n");
				if (s.equalsIgnoreCase("y")) {
					check = false;
				} else {
					check = true;
				}

			default:
				break;
			}

		}

		System.out.println("Thank you!");




	}

	public static String dateValidation(Scanner scan) {
		boolean check = false;
		String correctDate = null;
		while (!check) {
			System.out.println("Please enter date: mm/dd/yyyy ");
			correctDate = scan.nextLine();
			if (correctDate.matches("[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}")) {
				System.out.println("Valid Date!");
				check = true;
			} else {
				System.out.println("Sorry, Date is not valid!");
				check = false;
			}
		}
		return correctDate;
	}

	public static String nameValidation(Scanner scan) {
		boolean check = false;
		String correctName = null;
		while (!check) {
			System.out.println("Please enter a valid Name: ");
			correctName = scan.nextLine();
			if (correctName.matches("^[a-z A-Z ,.'-]{1,31}+$")) {
				System.out.println("Valid Name!");
				check = true;
			} else {
				System.out.println("Sorry, name is not valid!");
				check = false;
			}
		}
		return correctName;
	}

}
