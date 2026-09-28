import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bankPBO = new Bank();
        
        // ini contoh aja buat nasabah id 0
        bankPBO.addCustomer("Budi", "Santoso");
        bankPBO.getCustomer(0).setAccount(new Account(100000));

        int pilihan = 99; // nilai sembarang biar bisa perulangan
        
        while (pilihan != 0) {
            System.out.println("\n=== MENU BANK SEDERHANA ===");
            System.out.println("1. Tambah Nasabah Baru");
            System.out.println("2. Cek Saldo Nasabah");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            
            if (pilihan == 1) {
                System.out.print("Masukkan Nama Depan: ");
                String namaDepan = input.next();
                System.out.print("Masukkan Nama Belakang: ");
                String namaBelakang = input.next();
                
                bankPBO.addCustomer(namaDepan, namaBelakang);
                
                // Mengambil index nasabah yang baru saja dibuat
                int idBaru = bankPBO.getNumOfCustomers() - 1;
                
                // Otomatis membuatkan rekening kosong untuk nasabah baru tersebut
                bankPBO.getCustomer(idBaru).setAccount(new Account(0));
                
                System.out.println("Nasabah berhasil ditambahkan!");
                System.out.println("ID Nasabah kamu adalah: " + idBaru);
                
            } else if (pilihan == 2) {
                System.out.print("Masukkan ID Nasabah (contoh: 0): ");
                int id = input.nextInt();
            
                Customer nasabah = bankPBO.getCustomer(id); 
                Account rek = nasabah.getAccount(0);
                
                System.out.println("Saldo " + nasabah.getFirstName() + " saat ini: Rp " + rek.getBalance());
                
            } else if (pilihan == 3) {
                System.out.print("Masukkan ID Nasabah: ");
                int id = input.nextInt();
                System.out.print("Masukkan jumlah uang untuk disetor: ");
                double setor = input.nextDouble();

                Customer nasabah = bankPBO.getCustomer(id); 
                boolean sukses = nasabah.getAccount(0).deposit(setor);
                
                if(sukses) {
                    System.out.println("Setor tunai berhasil.");
                } else {
                    System.out.println("Gagal! Nominal harus lebih dari 0.");
                }
                
            } else if (pilihan == 4) {
                System.out.print("Masukkan ID Nasabah: ");
                int id = input.nextInt();
                System.out.print("Masukkan jumlah uang untuk ditarik: ");
                double tarik = input.nextDouble();

                Customer nasabah = bankPBO.getCustomer(id); 
                boolean sukses = nasabah.getAccount(0).withdraw(tarik);
                
                if(sukses) {
                    System.out.println("Tarik tunai berhasil.");
                } else {
                    System.out.println("Gagal! Saldo tidak mencukupi.");
                }
                
            } else if (pilihan == 0) {
                System.out.println("Program selesai. Terima kasih!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}