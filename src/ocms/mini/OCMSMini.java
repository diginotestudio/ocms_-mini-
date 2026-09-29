package ocms.mini;

import java.util.ArrayList;
import java.util.Scanner;

//Menambah class role user
    class Role {
        String userRole;
        String password ;
        
        Role (String userRole,String password){
            this.userRole = userRole;
            this.password = password;
        }           
    }
    
//Menambahkan variable remark
    class Complain {
        int id;
        String nama;
        String judul;
        String deskripsi;
        String kategori;
        String status;
        String remark;

//Parameter String status pada array dihilangkan
//Menambah inisiasi remark = null        
    Complain (int id, String nama, String judul, String deskripsi, String kategori) {
        this.id = id;
        this.nama = nama;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.status = "Dikirim";
        this.remark =null;
    }
}
public class OCMSMini {
    
//Menambahkan method roles dengan value terdefinisikan   
    static Role[] roles = {
            new Role("admin", "1234"),
            new Role("user", "")
        };
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Complain> complains = new ArrayList<>();

    static int nextId = 1;
    
//Menambahkan method selection input
    static int inputAngka() {
    while (true) {
        try {
            int angka = scanner.nextInt();
            scanner.nextLine();
            return angka;
        } catch (java.util.InputMismatchException e) {
            System.out.println("\nInput harus berupa angka.");
            scanner.nextLine();
            System.out.print("Coba lagi: ");
            
        }
    }
}
    public static void main(String[] args) {  
        
//Menambah calling method opsiStatus        
        opsiStatus();
    }
        
        static void opsiStatus() {
        int opsiStatus;
        do {

//Menambahkan method menu utama (inisiasi sebagai opsiStatus   
//Menambahkan opsi 'keluar'
        System.out.println("=====Welcome to Online Complaint Management System =====");
        System.out.println("Silakan masukkan status anda : ");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Keluar ");
        
        System.out.print("Pilih status: ");
            opsiStatus = inputAngka();  //ganti value dengan rule method

        System.out.println("\n");
            
// menambah switch pilihan role/status user;
//Menambahkan case 'keluar program'
         switch (opsiStatus) {
                case 1 -> adminlogin();
                case 2 -> dashboardUser();
                case 3 -> {System.out.print("Terima kasih telah menggunakan aplikasi ini.");
                System.exit(0);}
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        }   while (opsiStatus !=3);
    }

//menambah method login admin
//Menambahkan opsi kembali ke halaman utama
        static void adminlogin() {
        while (true) {
            System.out.println("===== Admin Login =====");
            System.out.println("Masukan password :");
            System.out.println("Pilih 0 untuk kembali ke halaman utama\n");
            System.out.print("Password : ");
            String passwordInput = scanner.nextLine ();

            if (passwordInput.equals("0")) {
                    return;
            } 
                if (passwordInput.equals (roles[0].password)) {
                    System.out.println("Password benar.\n");
                    dashboardAdmin ();
                    return;
                } else {
                    System.out.println("Password salah.");
                    System.out.println("Silakan coba lagi.\n");
                }
            }
        }

//Mengubah dashboard menjadi dashboard admin (all menu open)
//Menambahkan opsi 'keluar program' dan 'kembali ke halaman utama'
        static void dashboardAdmin(){
            int pilihan;
        do{
            System.out.println("  === OCMS : Admin Dashboard ===");
            System.out.println("1. Buat Pengaduan");
            System.out.println("2. Lihat Pengaduan");
            System.out.println("3. Cari Pengaduan");
            System.out.println("4. Update Pengaduan");
            System.out.println("5. Statistik Pengaduan");
            System.out.println("6. Kembali ke menu utama");
            System.out.println("7. Keluar\n");

            System.out.print("Pilih menu: ");
            pilihan = inputAngka(); //ganti value dengan rule method
                        
            System.out.println("\n");
            
            switch (pilihan) {
                case 1 -> tambahPengaduan();
                case 2 -> lihatPengaduan();
                case 3 -> cariPengaduan();
                case 4 -> updatePengaduan();
                case 5 -> statistikPengaduan();
                case 6 -> {return;}
                case 7 -> {System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                System.exit(0);}
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 7);
    }

//Menambah dashboard user reporter (menu terbatas)
//Menambahkan opsi 'keluar program' dan 'kembali ke halaman utama'
        static void dashboardUser(){
            int pilihan;
        do{
            System.out.println("  === OCMS : User Dashboard ===");
            
            System.out.println("0. Kembali");
            System.out.println("1. Buat Pengaduan");
            System.out.println("2. Lihat Pengaduan");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = inputAngka(); //ganti value dengan rule method
                        
            System.out.print("\n");
            
            switch (pilihan) {
                case 0 -> {return;}
                case 1 -> tambahPengaduan();
                case 2 -> lihatPengaduan();
                case 3 -> {System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                System.exit(0);}
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }

        
    static void tambahPengaduan() {
        System.out.println("\n");
        System.out.println("===== Buat Pengaduan =====");

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan judul pengaduan: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan deskripsi pengaduan: ");
        String deskripsi = scanner.nextLine();

        System.out.print("Masukkan kategori pengaduan: ");
        String kategori = scanner.nextLine();

//parameter status 'dikirim' dihilangkan karena sudah ada sudah didefinisikan object class complain"
        Complain complain = new Complain(nextId, nama, judul, deskripsi, kategori);

        complains.add(complain);
        
//mengubah nextId++ menjadi nextId (menghilangkan ++)        
        System.out.println("\nPengaduan berhasil ditambahkan.");
        System.out.println("ID Pengaduan: " + nextId + "\n");

        nextId++;        
    }
    
    static void lihatPengaduan() {
        System.out.println("===== Lihat Pengaduan =====");
        if (complains.isEmpty()) {
            System.out.println("Belum ada pengaduan yang dibuat.");
        } else {
            for (Complain complain : complains) {
                System.out.println("ID: " + complain.id);
                System.out.println("Nama: " + complain.nama);
                System.out.println("Judul: " + complain.judul);
                System.out.println("Deskripsi: " + complain.deskripsi);
                System.out.println("Kategori: " + complain.kategori);
                System.out.println("Status: " + complain.status);
                
//Menambahkan catatan (remark) pada status 'pending' dan 'ditolak'
//Menambah filter remark untuk selain dipending dan ditolak
            if (complain.remark != null 
                    && (complain.status.equals("Pending")
                    || complain.status.equals("Ditolak"))) {
                System.out.println("Catatan: " + complain.remark);
                }
                System.out.println("-------------------------");
            }
        }
            System.out.println("\n");
    }

    static void cariPengaduan() {
        System.out.println("\n");
        System.out.println("===== Cari Pengaduan =====");
        System.out.print("Masukkan ID pengaduan: ");
        int id = inputAngka();  //ganti value dengan rule method
       
        boolean found = false;
        for (Complain complain : complains) {
            if (complain.id == id) {
                System.out.println("ID: " + complain.id);
                System.out.println("Nama: " + complain.nama);
                System.out.println("Judul: " + complain.judul);
                System.out.println("Deskripsi: " + complain.deskripsi);
                System.out.println("Kategori: " + complain.kategori);
                System.out.println("Status: " + complain.status);
                
//Menambahkan catatan (remark) pada status 'pending' dan 'ditolak'
//Menambah filter remark untuk selain dipending dan ditolak
            if (complain.remark != null
                    && (complain.status.equals("Pending")
                    || complain.status.equals("Ditolak"))) {
                System.out.println("Catatan: " + complain.remark);
                }
                System.out.println("\n\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pengaduan dengan ID " + id + " tidak ditemukan.");
        }
    }

    static void updatePengaduan() {
        System.out.println("\n");
        System.out.println("===== Update Pengaduan =====");
        System.out.print("Masukkan ID pengaduan yang ingin diupdate: ");
        int id = inputAngka();
        int statusBaru;
 
            System.out.print("\n");
            
        boolean found = false;
        for (Complain complain : complains) {
            if (complain.id == id) {
                System.out.println("=== Masukan Status Baru ===");
                System.out.println("1. Dikirim");
                System.out.println("2. Diproses");
                System.out.println("3. Selesai");
                System.out.println("4. Pending");
                System.out.println("5. Ditolak \n");
                System.out.print("Pilih status baru : ");
                statusBaru  = inputAngka();
                                
//Menambahkan case 'pending'
                switch(statusBaru) {
                    case 1:
                        complain.status = "Dikirim";
                        break;
                    case 2:
                        complain.status = "Diproses";
                        break;
                    case 3:
                        complain.status = "Selesai";
                        break;
                    case 4:
                        complain.status = "Pending";
                        break;
                    case 5:
                        complain.status = "Ditolak";
                        break;
                    default:
                        System.out.println("Status tidak valid. Status tidak diperbarui.\n");
                        return;
                }
 //Menambahkan logic remark untuk case 'pending' dan 'ditolak               
                if (statusBaru == 4|| statusBaru == 5) {
                    System.out.println("Tuliskan alasan : ");
                complain.remark  = scanner.nextLine();
                }
                
                System.out.println("Status pengaduan berhasil diperbarui.\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pengaduan dengan ID " + id + " tidak ditemukan.\n");
        }
    }

//Menambahkan deklarasi int pending    
    static void statistikPengaduan() {
        int dikirim = 0;
        int diproses = 0;
        int selesai = 0;
        int pending = 0;
        int ditolak = 0;

//Menambahkan case pending        
        for (Complain complain : complains) {
            switch (complain.status) {
                case "Dikirim" -> dikirim++;
                case "Diproses" -> diproses++;
                case "Selesai" -> selesai++;
                case "Pending" -> pending++;
                case "Ditolak" -> ditolak++;
            }
        }

//Menambahkan status pending        
        System.out.println("===== Statistik Pengaduan =====");
        int totalPengaduan = complains.size();
        System.out.println("Total Pengaduan: " + totalPengaduan);
        System.out.println("Dikirim: " + dikirim);
        System.out.println("Diproses: " + diproses);
        System.out.println("Selesai: " + selesai);
        System.out.println("Pending: " + pending);
        System.out.println("Ditolak: " + ditolak);
        System.out.println("\n");
    }
}

