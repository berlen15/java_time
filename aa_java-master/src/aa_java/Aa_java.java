package aa_java;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Belen
 */
public class Aa_java {
    static boolean o = false;
    static boolean dt = false;
    static boolean coc = false;
    static boolean sh = false;
    static boolean rd = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2 || args[0] == "-h") {
            System.out.println("usage: java -jar <name.jar> file.txt [-c] [-s] [-r] [-di] [-do] [-dt]");
            System.out.println("options: \n-c,  "
                + " Cocktail Sorting execution\n-s, "
                + " Shell Sorting execution\n-r, "
                + " Radix Sorting execution\n-di,"
                + " Execution with input\n-do,"
                + " Execution with output\n-dt, Execution with time");
        } else {
            String thisLine = null;
            ArrayList<String> arrlist = new ArrayList<>();

            try {
                // open input stream test.txt for reading purpose.
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                while ((thisLine = br.readLine()) != null) {
                    arrlist.add(thisLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            int[] arr = new int[arrlist.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(arrlist.get(i));
            }

            for (int i = 1; i < args.length; i++) {
                if ("-c".equals(args[i])) {
                    coc = true;
                }else if ("-s".equals(args[i])){
                    sh=true;
                }else if ("-r".equals(args[i])){
                 rd=true;
                } else if ("-di".equals(args[i])) {
                    System.out.println("Input:");
                    for (int s : arr) {
                        System.out.print(s+" ");
                    }
                } else if ("-do".equals(args[i])) {
                    o = true;
                } else if ("-dt".equals(args[i])) {
                    dt = true;
                } else {
                    System.out.println("usage: java -jar <name.jar> file.txt [-c] [-s] [-r] [-di] [-do] [-dt]");
                    System.out.println("options: \n-c,  "
                    + " Cocktail Sorting execution\n-s, "
                    + " Shell Sorting execution\n-r, "
                    + " Radix Sorting execution\n-di,"
                    + " Execution with input\n-do,"
                    + " Execution with output\n-dt, Execution with time");
                    break;
                }
            }
            if (coc) {
                System.out.println();
                System.out.println("\nCOCKTAIL-SORT EXECUTING...");
                System.out.println();
                if (dt) {
                    long currentTimeMillis = System.currentTimeMillis();
                    CocktailSort.main(arr, o);
                    long res = System.currentTimeMillis() - currentTimeMillis;
                    System.out.println("\nExecution time (Cocktail-Sort): " + (long) res + " milliseconds");
                } else {
                    CocktailSort.main(arr,o);
                }
            }
            if (sh) {
                System.out.println();
                System.out.println("\nSHELL-SORT EXECUTING...");
                System.out.println();
                if (dt) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ShellSort.main(arr, o);
                    long res = System.currentTimeMillis() - currentTimeMillis;
                    System.out.println("\nExecution time (Shell-Sort): " + (long) res + " milliseconds");
                } else {
                    ShellSort.main(arr,o);
                }
            }
            if (rd) {
                System.out.println();
                System.out.println("\nRADIX-SORT EXECUTING...");
                System.out.println();
                if (dt) {
                    long currentTimeMillis = System.currentTimeMillis();
                    RadixSort.main(arr, o);
                    long res = System.currentTimeMillis() - currentTimeMillis;
                    System.out.println("\nExecution time (Radix-Sort): " + (long) res + " milliseconds");
                } else {
                    RadixSort.main(arr,o);
                }
            }
            
        }
    }
}
