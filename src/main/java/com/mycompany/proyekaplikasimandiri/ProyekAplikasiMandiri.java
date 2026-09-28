package com.mycompany.proyekaplikasimandiri;

import java.util.Scanner;

public class ProyekAplikasiMandiri {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("          GYMFLOW");
        System.out.println("     WORKOUT APPLICATION");

        System.out.println("\nData Pengguna");
        System.out.print("Nama         : ");
        String nama = input.nextLine();

        System.out.print("Umur         : ");
        int umur = input.nextInt();

        System.out.print("Berat Badan  : ");
        double beratBadan = input.nextDouble();
        input.nextLine();

        System.out.println("\nData Workout");
        System.out.print("Nama Workout : ");
        String namaWorkout = input.nextLine();

        System.out.print("Durasi       : ");
        int durasi = input.nextInt();
        input.nextLine();

        System.out.print("Level        : ");
        String level = input.nextLine();

        System.out.println("\nData Exercise");
        System.out.print("Nama Gerakan : ");
        String namaGerakan = input.nextLine();

        System.out.print("Target Otot  : ");
        String targetOtot = input.nextLine();

        System.out.print("Jumlah Set   : ");
        int set = input.nextInt();

        System.out.print("Repetisi     : ");
        int repetisi = input.nextInt();

        User user1 = new User(nama, umur, beratBadan);

        Workout workout1 = new Workout(
                namaWorkout,
                durasi,
                level
        );

        Exercise exercise1 = new Exercise(
                namaWorkout,
                durasi,
                level,
                namaGerakan,
                targetOtot,
                set,
                repetisi
        );

        System.out.println("\n          HASIL DATA");

        user1.tampilkanData();

        System.out.println();

        workout1.tampilkanWorkout();

        System.out.println();

        exercise1.tampilkanExercise();

        System.out.println("\n======================================");
        System.out.println("       SIMULASI GETTER & SETTER");
        System.out.println("======================================");

        System.out.println("\nData menggunakan Getter:");
        System.out.println("Nama Pengguna : " + user1.getNama());
        System.out.println("Umur          : " + user1.getUmur());
        System.out.println("Berat Badan   : " + user1.getBeratBadan());

        System.out.println("\n--- Perubahan Data Valid ---");

        user1.setNama("Muhammad Fathi");
        user1.setUmur(20);
        user1.setBeratBadan(65.5);

        System.out.println("Data berhasil diubah.");
        System.out.println("Nama Baru        : " + user1.getNama());
        System.out.println("Umur Baru        : " + user1.getUmur());
        System.out.println("Berat Badan Baru : " + user1.getBeratBadan());

        System.out.println("\n--- Perubahan Data Tidak Valid ---");

        user1.setUmur(-5);
        user1.setBeratBadan(-10);

        System.out.println("\nData setelah percobaan data tidak valid:");
        System.out.println("Nama        : " + user1.getNama());
        System.out.println("Umur        : " + user1.getUmur());
        System.out.println("Berat Badan : " + user1.getBeratBadan());

        input.close();
    }
}


class User {

    private String nama;
    private int umur;
    private double beratBadan;

    public User(String nama, int umur, double beratBadan) {
        this.nama = nama;
        this.umur = umur;
        this.beratBadan = beratBadan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid! Umur harus lebih dari 0.");
        }
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        if (beratBadan > 0) {
            this.beratBadan = beratBadan;
        } else {
            System.out.println("Berat badan tidak valid! Berat badan harus lebih dari 0.");
        }
    }

    public void tampilkanData() {
        System.out.println("Data Pengguna");
        System.out.println("Nama        : " + getNama());
        System.out.println("Umur        : " + getUmur() + " tahun");
        System.out.println("Berat Badan : " + getBeratBadan() + " kg");
    }
}


class Workout {

    protected String namaWorkout;
    protected int durasi;
    protected String level;

    public Workout(String namaWorkout, int durasi, String level) {
        this.namaWorkout = namaWorkout;
        this.durasi = durasi;
        this.level = level;
    }

    public String getNamaWorkout() {
        return namaWorkout;
    }

    public void setNamaWorkout(String namaWorkout) {
        this.namaWorkout = namaWorkout;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        if (durasi > 0) {
            this.durasi = durasi;
        } else {
            System.out.println("Durasi tidak valid! Durasi harus lebih dari 0.");
        }
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void tampilkanWorkout() {
        System.out.println("Data Workout");
        System.out.println("Nama        : " + getNamaWorkout());
        System.out.println("Durasi      : " + getDurasi() + " menit");
        System.out.println("Level       : " + getLevel());
    }
}


class Exercise extends Workout {

    private String namaGerakan;
    private String targetOtot;
    private int set;
    private int repetisi;

    public Exercise(
            String namaWorkout,
            int durasi,
            String level,
            String namaGerakan,
            String targetOtot,
            int set,
            int repetisi) {

        super(namaWorkout, durasi, level);

        this.namaGerakan = namaGerakan;
        this.targetOtot = targetOtot;
        this.set = set;
        this.repetisi = repetisi;
    }

    public String getNamaGerakan() {
        return namaGerakan;
    }

    public void setNamaGerakan(String namaGerakan) {
        this.namaGerakan = namaGerakan;
    }

    public String getTargetOtot() {
        return targetOtot;
    }

    public void setTargetOtot(String targetOtot) {
        this.targetOtot = targetOtot;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        if (set > 0) {
            this.set = set;
        } else {
            System.out.println("Jumlah set tidak valid!");
        }
    }

    public int getRepetisi() {
        return repetisi;
    }

    public void setRepetisi(int repetisi) {
        if (repetisi > 0) {
            this.repetisi = repetisi;
        } else {
            System.out.println("Jumlah repetisi tidak valid!");
        }
    }

    public void tampilkanExercise() {
        System.out.println("Data Exercise");

        System.out.println("Nama Workout : " + getNamaWorkout());
        System.out.println("Durasi       : " + getDurasi() + " menit");
        System.out.println("Level        : " + getLevel());

        System.out.println("Gerakan      : " + getNamaGerakan());
        System.out.println("Target Otot  : " + getTargetOtot());
        System.out.println("Set          : " + getSet());
        System.out.println("Repetisi     : " + getRepetisi());
    }
}