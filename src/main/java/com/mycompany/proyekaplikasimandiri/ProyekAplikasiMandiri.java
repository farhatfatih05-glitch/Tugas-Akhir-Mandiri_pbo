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
        Workout workout1 = new Workout(namaWorkout, durasi, level);
        Exercise exercise1 = new Exercise(
                namaGerakan,
                targetOtot,
                set,
                repetisi
        );

        System.out.println("          HASIL DATA");
  

        user1.tampilkanData();

        System.out.println();

        workout1.tampilkanWorkout();

        System.out.println();

        exercise1.tampilkanExercise();

        input.close();
    }
}

class User {

    String nama;
    int umur;
    double beratBadan;

    public User(String nama, int umur, double beratBadan) {
        this.nama = nama;
        this.umur = umur;
        this.beratBadan = beratBadan;
    }

    public void tampilkanData() {
        System.out.println("Data Pengguna");
        System.out.println("Nama        : " + nama);
        System.out.println("Umur        : " + umur + " tahun");
        System.out.println("Berat Badan : " + beratBadan + " kg");
    }
}

class Workout {

    String namaWorkout;
    int durasi;
    String level;

    public Workout(String namaWorkout, int durasi, String level) {
        this.namaWorkout = namaWorkout;
        this.durasi = durasi;
        this.level = level;
    }

    public void tampilkanWorkout() {
        System.out.println("Data Workout");
        System.out.println("Nama        : " + namaWorkout);
        System.out.println("Durasi      : " + durasi + " menit");
        System.out.println("Level       : " + level);
    }
}

class Exercise {

    String namaGerakan;
    String targetOtot;
    int set;
    int repetisi;

    public Exercise(String namaGerakan, String targetOtot, int set, int repetisi) {
        this.namaGerakan = namaGerakan;
        this.targetOtot = targetOtot;
        this.set = set;
        this.repetisi = repetisi;
    }

    public void tampilkanExercise() {
        System.out.println("Data Exercise");
        System.out.println("Gerakan     : " + namaGerakan);
        System.out.println("Target Otot : " + targetOtot);
        System.out.println("Set         : " + set);
        System.out.println("Repetisi    : " + repetisi);
    }
}