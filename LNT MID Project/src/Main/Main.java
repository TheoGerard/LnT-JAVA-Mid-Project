package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner sc = new Scanner (System.in);
	Random rd = new Random();
	String ID, newID;
	
	String[] Jabat = {"", "Manager", "Supervisor", "Admin"};
	int [] gajiJabatan = {0, 8000000, 6000000, 4000000};
		
	ArrayList<String> aNumber = new ArrayList<>();
	ArrayList<String> aName = new ArrayList<>();
	ArrayList<String> aGender = new ArrayList<>();
	ArrayList<String> aJabatan = new ArrayList<>();
	ArrayList<String> aID = new ArrayList<>();
	ArrayList<Integer> aGaji = new ArrayList<>();
	
	public Main() {
		mainMenu();
	}
	
	public void mainMenu( ) {
		
		int choose = 0;
		
		do {
			System.out.println("");
			System.out.println("PT MUSANG");
			System.out.println("=================");
			
			System.out.println("1. Input Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.print(">> ");
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1: {
				insertData();
			}
				break;
			case 2: {
				viewData();
			}
				break;
			case 3: {
				upData();
			}
				break;
			case 4: {
				deleteData();
			}
				break;
			case 5: {
				System.out.println("Terima Kasih!");
			}
				break;
			}
		} while (choose!=5);
	}
	
	public void insertData() {
		String name, gender;
		int Gaji = 0;
		int Jabatan;
		
		do {
			System.out.print("Input nama Karyawan : ");
			name = sc.nextLine();
		} while (name.length()<=3);
		
		do {
			System.out.print("Input Jenis Kelamin [Laki-Laki || Perempuan] : ");
			gender = sc.nextLine();
		} while (!gender.equals("Laki-Laki") && !gender.equals("Perempuan"));
		
		do {
			System.out.print("Input Jabatan (Angka) [1. Manager | 2. Supervisor | 3. Admin] : ");
			Jabatan = sc.nextInt(); sc.nextLine();
		} while (Jabatan < 1 || Jabatan > 3);

		for (int j = 1; j<3; j++) {
			if(Jabatan==j) aJabatan.add(Jabat[j]);
		}
		
		for (int i = 1; i<3; i++) {
			if(Jabatan==i) aGaji.add(gajiJabatan[i]);
		}
		
		
		
		int Random;
		for (int i=0;i<2; i++) {
			Random = rd.nextInt(26)+'A';			
			char randID1 = (char) Random;
			ID += randID1;
		}
		
		for (int i=0;i<4; i++) {
			Random = rd.nextInt(10)+'0';			
			char randID2 = (char) Random;
			ID += randID2;
		}
		
		
		System.out.println("");
		System.out.println("Berhasil menambahkan karyawan dengan ID : " + ID);
		System.out.println("Press enter to return");
		sc.nextLine();
		
		aID.add(ID);
		aName.add(name);
		aGender.add(gender);
	}
	
	public void viewData() {
		
		for (int i = 0; i<aName.size(); i++) {
			for (int j = i+1; j<aName.size(); j++) {
				if (aName.get(i).compareTo(aName.get(j))>0) {
					
					String temp = aID.get(i);
					aID.set(i, aID.get(j));
					aID.set(j, temp);

					String temp2 = aName.get(i);
					aName.set(i, aName.get(j));
					aName.set(j, temp2);
					
					String temp3 = aGender.get(i);
					aGender.set(i, aGender.get(j));
					aGender.set(j, temp3);
					
					String temp4 = aJabatan.get(i);
					aJabatan.set(i, aJabatan.get(j));
					aJabatan.set(j, temp4);

					int temp5 = aGaji.get(i);
					aGaji.set(i, aGaji.get(j));
					aGaji.set(j, temp5);
					
				}
			}
		}
		
		if(aName.isEmpty()) {
			System.out.println("No Data");
			mainMenu();
		}else {			
			System.out.println("");
			System.out.println("Data Karyawan");
			System.out.println("=================================");
			
			for (int i = 0; i < aName.size(); i++) {
				System.out.println("No : " + (i+1));
				System.out.println("Kode Karyawan : " + aID.get(i));
				System.out.println("Nama Karyawan : " + aName.get(i));
				System.out.println("Jenis Kelamin : " + aGender.get(i));
				System.out.println("Jabatan : " + aJabatan.get(i));
				System.out.println("Gaji Karyawan : Rp" + aGaji.get(i));
				System.out.println("");
			}
		}
	}
	
	public void upData() {
		int choose;
		String newName = null, newGender;
		int newGaji = 0;
		String newJabatan;
		
		if(aName.isEmpty()) {
			System.out.println("No Data Yet");
			mainMenu();
		}else {
			viewData();
			do {
				System.out.println("");
				System.out.println("Karyawan mana yang ingin di update? [1-" + aName.size() + "]");
				choose = sc.nextInt(); sc.nextLine();
			} while (choose < 1 || choose > aName.size());			
			
			do {
				System.out.print("Input nama karyawan : ");
				newName = sc.nextLine();
			} while (newName.length()<=3);
	
			aName.set(choose-1, newName);			
			
			do {
				System.out.print("Input Jenis Kelamin [Laki-Laki || Perempuan] : ");
				newGender = sc.nextLine();
			} while (!newGender.equals("Laki-Laki") && !newGender.equals("Perempuan"));
			
			aGender.set(choose-1, newGender);			

			do {
				System.out.print("Input Jabatan [Manager | Supervisor | Admin] : ");
				newJabatan = sc.nextLine();
			} while (!newJabatan.equals("Manager") && !newJabatan.equals("Supervisor") && !newJabatan.equals("Admin"));
			
			aJabatan.set(choose-1, newJabatan);
			
			for (int j = 1; j<3; j++) {
				if(newJabatan.equals("1")) aJabatan.add(Jabat[1]);
			}
			
			for (int i = 1; i<3; i++) {
				if(newJabatan.equals("1")) aGaji.add(gajiJabatan[1]);
			}

			for (int j = 2; j<3; j++) {
				if(newJabatan.equals("2")) aJabatan.add(Jabat[2]);
			}
			
			for (int i = 2; i<3; i++) {
				if(newJabatan.equals("2")) aGaji.add(gajiJabatan[2]);
			}

			for (int j = 3; j<3; j++) {
				if(newJabatan.equals("2")) aJabatan.add(Jabat[2]);
			}
			
			for (int i = 3; i<3; i++) {
				if(newJabatan.equals("3")) aGaji.add(gajiJabatan[3]);
			}
			
			int newRandom;
			for (int i=0;i<2; i++) {
				newRandom = rd.nextInt(26)+'A';			
				char randID1 = (char) newRandom;
				newID += randID1;
			}
			
			for (int i=0;i<4; i++) {
				newRandom = rd.nextInt(10)+'0';			
				char randID2 = (char) newRandom;
				newID += randID2;
			}
			
			System.out.println("");
			System.out.println("Berhasil mengupdate karyawan dengan ID : " + ID);
			System.out.println("Press enter to return");
			sc.nextLine();
			System.out.println("");
			
			mainMenu();
			
			aID.add(newID);
			aName.add(newName);
			aGender.add(newGender);
		}	
	}
	
	public void deleteData() {
		int choose;
		
		if(aName.isEmpty()) {
			System.out.println("No Data Yet");
			mainMenu();
		}else {
			viewData();
			do {
				System.out.println("");
				System.out.println("Input nomor urutan karyawan yang ingin dihapus [1-" + aName.size() + "]");
				choose = sc.nextInt(); sc.nextLine();
			} while (choose < 1 || choose > aName.size());
			
			aName.remove(choose-1);
			aGender.remove(choose-1);
			aJabatan.remove(choose-1);
			aID.remove(choose-1);
			
			System.out.println("Karyawan dengan kode " + ID + " berhasil dihapus");
			System.out.println("Press enter to return");
			sc.nextLine();
			mainMenu();
		}
	}
	
	public static void main(String[] args) {
		new Main();
		
	}

}
