import java.util.*;
import java.util.regex.*;

public class ArtikelProcessor {
    private static final String artikel =
            "Dalam kehidupan suatu negara, pendidikan memegang peranan yang amat penting untuk menjamin kelangsungan hidup negara dan bangsa, " +
            "karena pendidikan merupakan wahana untuk meningkatkan dan mengembangkan kualitas sumber daya manusia. Seiring dengan perkembangan teknologi komputer " +
            "dan teknologi informasi, sekolah-sekolah di Indonesia sudah waktunya mengembangkan Sistem Informasi manajemennya agar mampu mengikuti perubahan jaman.\n" +
            "SISKO mampu memberikan kemudahan pihak pengelola menjalankan kegiatannya dan meningkatkan kredibilitas dan akuntabilitas sekolah dimata siswa, orang tua siswa, " +
            "dan masyakat umumnya.Penerapan teknologi informasi untuk menunjang proses pendidikan telah menjadi kebutuhan bagi lembaga pendidikan di Indonesia. " +
            "Pemanfaatan teknologi informasi ini sangat dibutuhkan untuk meningkatkan efisiensi dan produktivitas bagi manajemen pendidikan. " +
            "Keberhasilan dalam peningkatan efisiensi dan produktivitas bagi manajemen pendidikan akan ikut menentukan kelangsungan hidup lembaga pendidikan itu sendiri. " +
            "Dengan kata lain menunda penerapan teknologi informasi dalam lembaga pendidikan berarti menunda kelancaran pendidikan dalam menghadapi persaingan global.\n";

    public static int searchWord(String word) {
        int count = 0;
        String lowerArtikel = artikel.toLowerCase();
        String lowerWord = word.toLowerCase();

        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(lowerWord) + "\\b");
        Matcher matcher = pattern.matcher(lowerArtikel);
        
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static String replaceWord(String oldWord, String newWord) {
        return artikel.replaceAll("(?i)\\b" + Pattern.quote(oldWord) + "\\b", newWord);
    }

    public static List<String> sortWords() {
        List<String> words = new ArrayList<>();
        String[] splitWords = artikel.split("[^a-zA-Z]+"); 

        for (String word : splitWords) {
            if (!word.isEmpty()) {
                words.add(word.toLowerCase());
            }
        }

        Collections.sort(words); 
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Pencarian berdasarkan kata");
            System.out.println("2. Penggantian Kata");
            System.out.println("3. Pengurutan kata berdasarkan abjad");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            

            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka antara 1 hingga 4.");
                System.out.print("Pilih opsi: ");
                scanner.next(); 
            }
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kata yang ingin dicari: ");
                    String searchTerm = scanner.nextLine();
                    int count = searchWord(searchTerm);
                    System.out.println("Kata '" + searchTerm + "' ditemukan sebanyak " + count + " kali.");
                    break;

                case 2:
                    System.out.print("Masukkan kata yang ingin diganti: ");
                    String oldWord = scanner.nextLine();
                    System.out.print("Masukkan kata pengganti: ");
                    String newWord = scanner.nextLine();
                    System.out.println("\nArtikel setelah penggantian kata:\n");
                    System.out.println(replaceWord(oldWord, newWord));
                    break;

                case 3:
                    System.out.println("\nDaftar kata yang terurut abjad:");
                    List<String> sortedWords = sortWords();
                    for (String word : sortedWords) {
                        System.out.println(word);
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
