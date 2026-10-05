# OCMS Mini

## Online Complaint Management System

> **Status:** Developing/ on progress
> **Project type:** College Project / UTS Java CLI Mini Project\
> **Storage:** In-memory (`ArrayList`)\
> **Database:** Not used

---

## 1. Overview

OCMS Mini adalah program **Online Complaint Management System**
sederhana yang dibuat sebagai proyek pembelajaran Java.

Program ini mensimulasikan proses dasar pengelolaan pengaduan:

1.  User membuat pengaduan.
2.  Sistem memberikan ID pengaduan.
3.  Admin dapat melihat dan mencari pengaduan.
4.  Admin dapat memperbarui status pengaduan.
5.  Admin dapat memberikan remark untuk pengaduan yang berstatus
    **Pending** atau **Ditolak**.
6.  Admin dapat melihat statistik berdasarkan status.

Project ini masih dalam tahap developing dan ditujukan sebagai
project Tugas Akhir Mata Kuliah Pemrograman Berbasis Objek (Java)

---

## 2. Fundamental Project OCMS

Berikut hal yang menjadi dasar dalam membuat project ini:

- program Java berbasis CLI;
- menggunakan class dan object;
- menggunakan constructor;
- menggunakan `ArrayList` untuk menyimpan object;
- menggunakan `if`, `switch`, loop, dan method;
- membuat validasi input;
- menggunakan exception handling sederhana;
- membuat alur proses berdasarkan kebutuhan masalah;
- memahami dasar modularitas dan OOP.

Tujuan utamanya adalah untuk **belajar merancang solusi dan mengimplementasikannya ke dalam
program Java**.

---

## 3. Konsep Sistem

OCMS Mini memiliki dua role:

### User

User dapat:

- membuat pengaduan;
- melihat daftar pengaduan;
- kembali ke menu utama.

### Admin

Admin dapat:

- login;
- membuat pengaduan;
- melihat seluruh pengaduan;
- mencari pengaduan berdasarkan ID;
- memperbarui status pengaduan;
- memberikan remark;
- melihat statistik pengaduan.

---

## 4. Struktur Class Saat Ini

Program saat ini masih menggunakan satu file Java.

### `Role`

Menyimpan data role dan password.

```java
class Role {
    String userRole;
    String password;
}
```

Role yang tersedia:

- `admin`
- `user`

### `Complain`

Mewakili satu object pengaduan.
Data yang digunakan saat ini:

```text
id
nama
judul
deskripsi
kategori
status
remark
```

Saat object `Complain` dibuat:

```text
status = "Dikirim"
remark = null
```

### `OCMSMini`

Merupakan public class sekaligus tempat utama program berjalan.

Class OCMSMini saat ini menangani:

- menu utama;
- login admin;
- dashboard admin;
- dashboard user;
- input data;
- penyimpanan `ArrayList`;
- pencarian;
- update status;
- statistik;
- validasi input angka.

---

## 5. Penyimpanan Data

Data complaint saat ini disimpan di memory menggunakan:

```java
static ArrayList<Complain> complains
```

Artinya data hanya tersedia selama program sedang berjalan.

Ketika program dihentikan, data akan hilang.

---

## 6. ID Pengaduan

Setiap complaint mendapatkan ID dari:

```java
static int nextId = 1;
```

Saat complaint baru dibuat:

1.  nilai `nextId` digunakan sebagai ID;
2.  object `Complain` dimasukkan ke `ArrayList`;
3.  `nextId` ditambah satu.

Contoh:

```text
Complaint pertama → ID 1
Complaint kedua   → ID 2
Complaint ketiga  → ID 3
```

---

## 7. Status Pengaduan

Status yang tersedia saat ini:

---

     1 Dikirim
     2 Diproses
     3 Selesai
     4 Pending
     5 Ditolak

Admin dapat memilih status ketika melakukan update complaint.

Jika status menjadi:

- `Pending`
- `Ditolak`

maka admin diminta memberikan **remark**.

---

## 8. Alur Program Saat Ini

### Main Menu

```text
+----------------+
|   OCMS Mini    |
+----------------+
| 1. Admin       |
| 2. User        |
| 0. Exit        |
+----------------+
```

### Admin Flow

```text
Main Menu
   ↓
Admin Login
   ↓
Admin Dashboard
   ├── Tambah Pengaduan
   ├── Lihat Pengaduan
   ├── Cari Pengaduan
   ├── Update Pengaduan
   ├── Statistik
   └── Kembali / Exit
```

### User Flow

```text
Main Menu
   ↓
User Dashboard
   ├── Tambah Pengaduan
   ├── Lihat Pengaduan
   └── Kembali
```

---

## 9. Membuat Pengaduan

Saat membuat complaint, user memasukkan:

```text
Nama
Judul
Deskripsi
Kategori
```

Program kemudian membuat object:

```java
Complain complain = new Complain(
    nextId,
    nama,
    judul,
    deskripsi,
    kategori
);
```

Object tersebut dimasukkan ke:

```java
complains.add(complain);
```

Kemudian ID berikutnya dinaikkan (bertambah 1).

---

## 10. Melihat Pengaduan

Program melakukan loop terhadap `ArrayList` dan menampilkan complaint
yang tersedia.

Informasi utama yang ditampilkan:

```text
ID
Nama
Judul
Deskripsi
Kategori
Status
Remark
```

Remark hanya ditampilkan jika:

```text
status = Pending
atau
status = Ditolak
```

---

## 11. Mencari Pengaduan

Admin dapat mencari complaint berdasarkan ID.

Logikanya:

```text
Input ID
   ↓
Loop seluruh ArrayList
   ↓
Bandingkan complaint.id dengan ID input
   ↓
Jika ditemukan → tampilkan complaint
Jika tidak ditemukan → tampilkan pesan
```

Pencarian ini menggunakan **linear search** karena data masih disimpan
dalam `ArrayList`.

---

## 12. Update Pengaduan

Admin dapat memilih complaint berdasarkan ID lalu mengubah statusnya.

Contoh:

```text
Dikirim
   ↓
Diproses
   ↓
Selesai
```

Atau complaint dapat diberi status:

```text
Pending
```

atau

```text
Ditolak
```

Jika memilih `Pending` atau `Ditolak`, admin memasukkan remark.

---

## 13. Statistik

Program memiliki statistik sederhana berdasarkan jumlah complaint pada
setiap status.

Contoh:

```text
Dikirim  : 3
Diproses : 2
Selesai  : 5
Pending  : 1
Ditolak  : 1
```

Perhitungan dilakukan dengan melakukan loop terhadap seluruh complaint
dan menggunakan `switch` berdasarkan status.

---

## 14. Input Validation dan Exception Handling

Program sudah memiliki method:

```java
static int inputAngka()
```

Method ini digunakan untuk membaca input angka.

Jika user memasukkan input bukan angka, program menangkap:

```java
InputMismatchException
```

kemudian meminta user memasukkan angka kembali.

Konsepnya:

```text
Input
 ↓
Apakah angka?
 ├── Ya → lanjut
 └── Tidak → tampilkan pesan → input ulang
```

Method ini digunakan pada beberapa bagian program yang membutuhkan input
integer, seperti menu, ID complaint, dan pilihan status.

---

# 15. Roadmap Pengembangan

Pengembangan berikutnya tetap dibuat dalam scope **project tugas akhir mata kuliah pemrogrmana berorientasi object (java)**.
Fitur yang dipilih berfokus pada penambahan logic sederhana.

## Tahap 1 --- Category Terstruktur

Saat ini kategori masih diinput oleh user.

Pengembangan berikutnya:

```text
1. IT
2. Facility
3. Security
4. Other
```

User memilih kategori dari pilihan yang sudah ditentukan.

Tujuannya:

- menghindari perbedaan penulisan;
- membuat data lebih konsisten;
- kategori dapat digunakan oleh logic program berikutnya.

---

## Tahap 2 --- Responsible Section

Kategori dapat digunakan untuk menentukan bagian yang bertanggung jawab.

Contoh:

```text
IT       → IT Support
Facility → Facility Management
Security → Security
```

Sehingga setelah user memilih kategori, sistem dapat menentukan
responsible section secara otomatis.

Contoh:

```text
Kategori:
IT

Responsible:
IT Support
```

Ini menambahkan logic sederhana tanpa membuat sistem menjadi terlalu
kompleks.

---

## Tahap 3 --- Complaint Date

Sistem dapat mencatat tanggal ketika complaint dibuat.

Contoh:

```text
Complaint Date: 30-09-2026
```

Tanggal dapat dibuat otomatis oleh program ketika object complaint
dibuat.

Tujuannya agar complaint tidak hanya memiliki ID, tetapi juga memiliki
informasi kapan complaint dibuat.

---

## Tahap 4 --- Complaint Age / Lama Pengaduan

Setelah complaint memiliki tanggal, program dapat menghitung berapa lama
complaint sudah berada di sistem.

Contoh:

```text
Complaint Date : 27-09-2026
Today          : 30-09-2026
Age            : 3 days
```

Logic ini dapat digunakan untuk mengetahui complaint yang sudah lama
belum selesai.

---

## Tahap 5 --- Impact Level dan Urgency

Complaint dapat diberikan tingkat impact berdasarkan seberapa banyak
orang yang terdampak.

Contoh:

```text
Low
Medium
High
```

Misalnya:

```text
Low    → berdampak pada sedikit orang
Medium → berdampak pada beberapa orang
High   → berdampak pada banyak orang
```

Impact level tersebut kemudian dapat digunakan sebagai dasar untuk
menentukan **urgency** complaint.

Fokusnya adalah belajar membuat logic berdasarkan data complaint.

---

## Tahap 6 --- Sorting dan Filtering

Admin dapat memiliki pilihan untuk melihat complaint berdasarkan kondisi
tertentu.

Contoh:

```text
1. Semua Complaint
2. Urgency High
3. Urgency Low
4. Complaint Terlama
```

Fitur ini dapat digunakan untuk :

- sorting;
- filtering;
- perbandingan object;
- pengolahan data dalam `ArrayList`.

---

## Tahap 7 --- Complaint History

Complaint dapat menyimpan riwayat perubahan status.

Contoh:

```text
Dikirim
   ↓
Diproses
   ↓
Pending
   ↓
Diproses
   ↓
Selesai
```

Implementasi sederhana dapat menggunakan:

```java
ArrayList<String> history;
```

Kemudian setiap kali status berubah, program menambahkan informasi ke
history.

Contoh:

```text
Dikirim -> Diproses
Diproses -> Pending
Pending -> Diproses
Diproses -> Selesai
```

History bisa digunakan untuk sistem audit sederhana.

---

# 16. Target Struktur Data Setelah Pengembangan

Jika roadmap di atas diterapkan, object `Complain` secara bertahap dapat
berkembang menjadi:

```text
Complain
│
├── id
├── nama
├── judul
├── deskripsi
├── kategori
├── responsibleSection
├── tanggal
├── impactLevel
├── urgency
├── status
├── remark
└── history
```


---

# 17. Progres Project Saat Ini

Project saat ini sudah memiliki beberapa konsep dasar :

- class;
- object;
- constructor;
- ArrayList;
- method;
- static method;
- switch;
- loop;
- searching;
- counting/statistics;
- input validation;
- exception handling;
- role;
- status management.

Namun, sebagian besar logic masih berada di dalam `OCMSMini`.

Project ini sudah menggunakan object dan class, tetapi **belum
sepenuhnya modular**.

Pengembangan OOP berikutnya dapat dilakukan setelah logic utama sudah
stabil.

---

# 18. Arah Refactoring OOP

Jika nanti project ingin dikembangkan untuk latihan OOP lebih lanjut,
class dapat dipisahkan berdasarkan tanggung jawab.

Contoh sederhana:

```text
OCMSMini
│
├── Role
├── Complain
└── ...
```

Kemudian logic yang terlalu banyak berada di `OCMSMini` dapat
dipertimbangkan untuk dipisahkan.


# 19. Batasan Project

Project ini sengaja memiliki batasan agar tetap sesuai dengan level
pembelajaran.

### Saat ini tidak menggunakan:

- database;
- GUI;
- web application;
- authentication yang kompleks;
- API;
- sistem multi-user nyata;
- SLA;
- workload management;
- arsitektur enterprise;
- fitur AI.

Data hanya berada di memory selama program berjalan.

---

# 20. Catatan Development

Project masih dalam tahap **developing**.

Fitur yang sudah ada tidak harus dianggap sebagai desain final. Roadmap
digunakan sebagai arah pengembangan bertahap.

Prioritas pengembangan adalah menambah **logic yang dapat dipahami dan
dipertanggungjawabkan dalam konteks tugas kuliah**.

---

## 21. Kesimpulan

OCMS Mini merupakan project Java CLI untuk mempraktikkan bagaimana
sebuah masalah sederhana dapat diterjemahkan menjadi program.

Alur utamanya:

```text
User membuat complaint
        ↓
Complaint disimpan
        ↓
Admin melihat / mencari complaint
        ↓
Admin memperbarui status
        ↓
Complaint dapat memiliki remark
        ↓
Sistem menghitung statistik
```

Pengembangan berikutnya diarahkan untuk menambahkan logic:

```text
Category
   ↓
Responsible Section

Complaint Date
   ↓
Complaint Age

Impact Level
   ↓
Urgency

Sorting / Filtering
   ↓
Complaint History
```

Dengan demikian, project tetap sederhana dan sesuai untuk pembelajaran
semester awal, tetapi secara bertahap menunjukkan penggunaan **OOP,
struktur data, algoritma, input validation, exception handling, dan
problem solving** dalam sebuah aplikasi yang memiliki alur nyata.
