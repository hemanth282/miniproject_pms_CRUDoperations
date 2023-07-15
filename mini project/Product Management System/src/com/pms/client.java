package com.pms;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {

		boolean flag = true;

		Scanner sc = new Scanner(System.in);
		Product dao = new Product();
		IProductService service = new ProductServiceImp();

		while (flag) {

			System.out.println("WELCOME TO PMS");
			System.out.println("1. ADD Product");
			System.out.println("2. UPDATE Product");
			System.out.println("3. DELETE Product");
			System.out.println("4. SELECT Product");
			System.out.println("5. SELECT ALL");
			System.out.println("0. EXIT");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Prod No.");
				int pno1 = sc.nextInt();
				System.out.println("Enter Prod Name");
				String pname1 = sc.next();
				System.out.println("Enter Price");
				double price1 = sc.nextDouble();
				System.out.println("Enter Manufacture Date");
				String date1 = sc.next();

				Date date = Date.valueOf(date1);

				Product prod1 = new Product();
				prod1.setPid(pno1);
				prod1.setPname(pname1);
				prod1.setPrice(price1);
				prod1.setDom(date1);
				int count = service.addProd(prod1);

				System.out.println(count + " Product inserted");

				break;
			case 2:
				System.out.println("Enter Prod No.");
				int pno2 = sc.nextInt();
				System.out.println("Enter Prod Name");
				String pname2 = sc.next();
				System.out.println("Enter Price");
				double price2 = sc.nextDouble();
				System.out.println("Enter Manufacture Date");
				String date2 = sc.next();

				Date date3 = Date.valueOf(date2);
				Product prod2 = new Product();

				prod2.setPid(pno2);
				prod2.setPname(pname2);
				prod2.setPrice(price2);
				prod2.setDom(date2);
				int count1 = service.updateProd(prod2);

				System.out.println(count1 + " records updated");

				break;

			case 3:
				System.out.println("Enter ProdNo to delete one record");

				int pno3 = sc.nextInt();

				int count3 = service.deleteProdById(pno3);

				System.out.println(count3 + " record deleted");

				if (count3 == 0) {

					try {
						throw new ProdNotFoundException();
					} catch (Exception e) {

						System.err.println("Dept Not Found , Cant delete record");
					}
				}

				break;
			case 4:
				System.out.println("Enter pid to select record");
				int pno4 = sc.nextInt();

				Product prodObj = service.getProdById(pno4);

				System.out.println(prodObj);

				if (prodObj == null) {

					try {
						throw new ProdNotFoundException();
					} catch (Exception e) {
						System.err.println("Record Not Found");
					}
				}
				break;

			case 5:

				List<Product> list = service.getAll();

				for (Product prod : list) {
					System.out.println(prod);

				}

				break;
			case 0:
				flag = false;

				DBUtil.closeConncetion();
				System.out.println("Thank you visit again..");
				break;
			default:
				System.err.println("Invalid Input");
				break;

			}

		}

	}

}
