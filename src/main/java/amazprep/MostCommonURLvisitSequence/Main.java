package amazprep.MostCommonURLvisitSequence;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 1/16/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        String url1 = "www.google.com";
        String url2 = "www.amazon.com";
        String url3 = "www.ebay.com";
        String seq1 = url1.concat(url2).concat(url3);
        String seq2 = url2.concat(url3).concat(url1);
        String seq3 = url3.concat(url1).concat(url2);
        System.out.println(seq1.hashCode() == seq2.hashCode());
        System.out.println(seq2.hashCode() == seq3.hashCode());
        System.out.println(seq3.hashCode() == seq1.hashCode());
        System.out.println(seq1.equals(seq2));
        System.out.println(factorial(4));
        System.out.println((factorial(8)/0.75F)+1);
    }

    // 1! = 1
    // 2! = 2
    // 3! = 6
    // 4! = 24
    static int factorial(int number) {
        if (number == 0 || number == 1)
            return 1;
        return number * factorial(number-1);
        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.get()
        Hashtable ht = new Hashtable();
        ht.get()
    }
}
