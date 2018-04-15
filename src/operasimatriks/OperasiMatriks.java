package operasimatriks;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Umar Al-Faruq
 */
class OperasiMatriks {

    public static void main(String[] args) {
        /*
        * auto input matriks pertama
        **/
        System.out.println("Matriks A");
        int[][] A = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = ThreadLocalRandom.current().nextInt(-16, 16);         //input angka random dengan batas bawah dan atas: -16 dan 16
                System.out.print(A[i][j] + "\t");
            }
            System.out.println("");
        }

        /*
        * auto input matriks kedua
        **/
        System.out.println("Matriks B");
        int[][] B = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                B[i][j] = ThreadLocalRandom.current().nextInt(-16, 16);         //input angka random dengan batas bawah dan atas: -16 dan 16
                System.out.print(B[i][j] + "\t");
            }
            System.out.println("");
        }

        OperasiMatriks om = new OperasiMatriks();
        om.play(A, B);                                                          //OPERASI MATRIKS
    }

    //Method mencetak menu operasi
    public void displayMenu() {
        System.out.println("Menu operasi");
        System.out.println("   1. Penjumlahan\n"
                + "   2. Pengurangan\n"
                + "   3. Perkalian\n"
                + "   4. Perkalian dengan skalar\n"
                + "   5. Transpose\n"
                + "   0. Keluar");
    }

    //Method memasukkan pilihan operasi
    public int promptPilihan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pilih operasi: ");
        int operasi = sc.nextInt();
        return operasi;
    }

    //Method perulangan (sesuai pilihan)
    public void play(int[][] A, int[][] B) {
        int p;
        do {
            displayMenu();                                                      //Memanggil method displayMenu()
            p = promptPilihan();                                                //Memanggil method promptPilihan() dan menyimpan dalam variable p
            processByPilihan(p, A, B);                                          //Memanggil method processByPilihan() dan mencetak operasi yang dipilih
        } while (p != 0);
    }

    //Mthod mencetak hasil operasi yang dipilih
    public void processByPilihan(int p, int[][] A, int[][] B) {
        switch (p) {
            case 1:
                System.out.println("Hasil A + B = ");
                cetak(countPenjumlahan(A, B));
                System.out.println("");
                break;
            case 2:
                System.out.println("Hasil A - B = ");
                cetak(countPengurangan(A, B));
                System.out.println("");
                break;
            case 3:
                System.out.println("Hasil A * B = ");
                cetak(countPerkalian(A, B));
                System.out.println("");
                break;
            case 4:
                System.out.println("Hasil k * A = ");
                cetak(countPerkalianSkalar(A));
                System.out.println("");

                System.out.println("Hasil k * B = ");
                cetak(countPerkalianSkalar(B));
                System.out.println("");
                break;
            case 5:
                System.out.println("Hasil transpose A = ");
                cetak(transpose(A));
                System.out.println("");

                System.out.println("Hasil transpose B = ");
                cetak(transpose(B));
                System.out.println("");
                break;
            default:
                System.out.println("Terima kasih");
        }
    }

    //Method mencetak matriks
    public void cetak(int[][] x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    //Method penjumlahan matriks
    public int[][] countPenjumlahan(int[][] x, int[][] y) {
        int[][] hasil = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = x[i][j] + y[i][j];
            }
        }
        return hasil;
    }

    //Method pengurangan matriks
    public int[][] countPengurangan(int[][] x, int[][] y) {
        int[][] hasil = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = x[i][j] - y[i][j];
            }
        }
        return hasil;
    }

    //Method perkalian matriks
    public int[][] countPerkalian(int[][] x, int[][] y) {
        int[][] hasil = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    hasil[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return hasil;
    }

    //Method perkalian matriks dengan skalar
    public int[][] countPerkalianSkalar(int[][] x) {
        Scanner sc = new Scanner(System.in);
        int[][] hasil = new int[3][3];
        System.out.print("Masukkan nilai skalar : ");
        int k = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = k * x[i][j];
            }
        }
        return hasil;
    }

    //Method transpose matriks
    public int[][] transpose(int[][] x) {
        int[][] hasil = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = x[j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hasil[i][j] = hasil[i][j];
            }
        }
        return hasil;
    }
}
