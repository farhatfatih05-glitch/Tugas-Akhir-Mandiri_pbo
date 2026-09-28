package com.mycompany.proyekaplikasimandiri;

import java.util.Scanner;

public class ProyekAplikasiMandiri {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== GYMFLOW ==========");
        System.out.println("     WORKOUT APPLICATION");

        System.out.println("\nData Pengguna");

        System.out.print("Nama        : ");
        String nama = input.nextLine();

        System.out.print("Umur        : ");
        int umur = input.nextInt();

        System.out.print("Berat Badan : ");
        double berat = input.nextDouble();
        input.nextLine();

        User user = new User(nama, umur, berat);

        System.out.println("\nPilih Workout");
        System.out.println("1. Chest Day");
        System.out.println("2. Back Day");
        System.out.println("3. Leg Day");
        System.out.println("4. Arm Day");

        System.out.print("Pilihan : ");
        int pilihan = input.nextInt();
        input.nextLine();

        System.out.print("Durasi : ");
        int durasi = input.nextInt();
        input.nextLine();

        System.out.print("Level : ");
        String level = input.nextLine();

        Workout workout;

        if (pilihan == 1)
            workout = new ChestWorkout("Chest Day", durasi, level);
        else if (pilihan == 2)
            workout = new BackWorkout("Back Day", durasi, level);
        else if (pilihan == 3)
            workout = new LegWorkout("Leg Day", durasi, level);
        else
            workout = new ArmWorkout("Arm Day", durasi, level);

        System.out.println("\nData Exercise");

        System.out.print("Nama Gerakan : ");
        String gerakan = input.nextLine();

        System.out.print("Target Otot : ");
        String otot = input.nextLine();

        System.out.print("Berat Beban : ");
        double beban = input.nextDouble();

        System.out.print("Set : ");
        int set = input.nextInt();

        System.out.print("Repetisi : ");
        int repetisi = input.nextInt();

        Exercise exercise = new Exercise(
                gerakan, otot, beban, set, repetisi
        );

        System.out.println("\n========== HASIL DATA ==========");

        user.tampilkanData();

        System.out.println();
        workout.tampilkanWorkout();

        System.out.println();
        exercise.tampilkanExercise();

        System.out.println("\nKalori : "
                + workout.hitungKalori() + " kcal");

        workout.mulaiWorkout();
        workout.selesaiWorkout();

        System.out.println("\n========== OVERLOADING ==========");

        exercise.tambahExercise("Bench Press");
        exercise.tambahExercise("Bench Press", 4);
        exercise.tambahExercise("Bench Press", 4, 10);

        System.out.println("\n========== GETTER & SETTER ==========");

        System.out.println("Nama : " + user.getNama());
        System.out.println("Umur : " + user.getUmur());
        System.out.println("Berat : " + user.getBeratBadan());

        user.setNama("Muhammad Fathi");
        user.setUmur(20);
        user.setBeratBadan(65.5);

        user.setUmur(-5);
        user.setBeratBadan(-10);

        System.out.println("\nData Akhir");
        user.tampilkanData();

        input.close();
    }
}


interface Trackable {

    void mulaiWorkout();

    void selesaiWorkout();
}


abstract class Workout implements Trackable {

    private String namaWorkout;
    private int durasi;
    private String level;

    public Workout(String namaWorkout, int durasi, String level) {
        this.namaWorkout = namaWorkout;
        this.durasi = durasi;
        this.level = level;
    }

    public String getNamaWorkout() {
        return namaWorkout;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getLevel() {
        return level;
    }

    public abstract double hitungKalori();

    public void tampilkanWorkout() {

        System.out.println("Workout : " + namaWorkout);
        System.out.println("Durasi  : " + durasi + " menit");
        System.out.println("Level   : " + level);
    }

    @Override
    public void mulaiWorkout() {
        System.out.println("Workout dimulai!");
    }

    @Override
    public void selesaiWorkout() {
        System.out.println("Workout selesai!");
    }
}


class ChestWorkout extends Workout {

    public ChestWorkout(String nama, int durasi, String level) {
        super(nama, durasi, level);
    }

    @Override
    public double hitungKalori() {
        return getDurasi() * 7.5;
    }
}


class BackWorkout extends Workout {

    public BackWorkout(String nama, int durasi, String level) {
        super(nama, durasi, level);
    }

    @Override
    public double hitungKalori() {
        return getDurasi() * 8;
    }
}


class LegWorkout extends Workout {

    public LegWorkout(String nama, int durasi, String level) {
        super(nama, durasi, level);
    }

    @Override
    public double hitungKalori() {
        return getDurasi() * 9;
    }
}


class ArmWorkout extends Workout {

    public ArmWorkout(String nama, int durasi, String level) {
        super(nama, durasi, level);
    }

    @Override
    public double hitungKalori() {
        return getDurasi() * 6.5;
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

    public int getUmur() {
        return umur;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {

        if (umur > 0)
            this.umur = umur;
        else
            System.out.println("Umur tidak valid!");
    }

    public void setBeratBadan(double berat) {

        if (berat > 0)
            this.beratBadan = berat;
        else
            System.out.println("Berat badan tidak valid!");
    }

    public void tampilkanData() {

        System.out.println("\nData Pengguna");
        System.out.println("Nama   : " + nama);
        System.out.println("Umur   : " + umur + " tahun");
        System.out.println("Berat  : " + beratBadan + " kg");
    }
}


class Exercise {

    private String namaGerakan;
    private String targetOtot;
    private double beratBeban;
    private int set;
    private int repetisi;

    public Exercise(
            String namaGerakan,
            String targetOtot,
            double beratBeban,
            int set,
            int repetisi) {

        this.namaGerakan = namaGerakan;
        this.targetOtot = targetOtot;
        this.beratBeban = beratBeban;
        this.set = set;
        this.repetisi = repetisi;
    }

    public void tambahExercise(String nama) {
        System.out.println("Exercise : " + nama);
    }

    public void tambahExercise(String nama, int set) {
        System.out.println("Exercise : " + nama + ", Set : " + set);
    }

    public void tambahExercise(
            String nama, int set, int repetisi) {

        System.out.println(
                "Exercise : " + nama +
                ", Set : " + set +
                ", Repetisi : " + repetisi
        );
    }

    public void tampilkanExercise() {

        System.out.println("Data Exercise");
        System.out.println("Gerakan : " + namaGerakan);
        System.out.println("Otot    : " + targetOtot);
        System.out.println("Beban   : " + beratBeban + " kg");
        System.out.println("Set     : " + set);
        System.out.println("Repetisi: " + repetisi);
    }
}