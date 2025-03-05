Java Spring Boot Project

Prerequisites
- Java 11 atau lebih tinggi
- Maven 3.6 atau lebih tinggi
- Spring Boot 2.3 atau lebih tinggi

Cara Menjalankan Project
- Clone repository ini ke direktori lokal Anda.
- Buka terminal dan navigasikan ke direktori project.
- Jalankan perintah *mvn clean install* untuk membuild dan menginstal dependensi.
- Jalankan perintah *mvn spring-boot:run* / run langsung dari compiler untuk menjalankan aplikasi Spring Boot.
- Akses aplikasi melalui URL *http://localhost:8000/api/notes* di browser Anda.

Function yang Tersedia
- GET /api/notes: Mendapatkan daftar catatan
- POST /api/notes: Menambahkan catatan baru
- DELETE /notes/{id}: Menghapus catatan dengan ID tertentu