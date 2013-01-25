package amazprep.mostCommonURLvisitSequence;

import sun.awt.windows.ThemeReader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This implementation of the finder is not designed for use in the environment with concurrent access
 * User: Alexander
 * Date: 1/16/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public final class MostPopularSequenceFinder {
    // there might be 8! sequences
    private Map<Sequence, AtomicInteger> seq_counters = new Hashtable<Sequence, AtomicInteger>();

    // maps used id, assume it is string, to the most recent running sequence, last two urls of the particular user offered to this Finder by eternal producer.
    private Map<String, LinkedList<String>> user_rs= new HashMap<String, LinkedList<String>>();

    //
    public void offer(String userId, String url) {
        // 1. check if there is record by userId in the user_rs
        // 2. if no create one and add url to that LinkedList (further LL)
        // 3. if yes get it and check the size of that LL
        // 4. if it is 1 just add the url to it and return.
        // 5. if size is 2 call SequenceProducer.getSequenceFor(LL.getFirst(), LL.getLast(), url) to get a Sequence (further S)
        // 6. do LL.poll(); LL.offer(url); to keep track of two most recent sequential urls for this userID
        // 7. if (seq_counters.containsKey(S)) get is and increment the counter;
        // 8. else put(S, new AtomicInteger(1));

    }

//    //
//    public void offer(String logRecord) {
//        // parse userId and url;
//    }

    public List getMostPopularSequence() {
        Sequence maxOne = null;
        AtomicInteger maxCount = new AtomicInteger();
        for (Sequence seq : seq_counters.keySet()) {
            if (seq_counters.get(seq).intValue() > maxCount.intValue()) {
                maxOne = seq;
                maxCount = seq_counters.get(seq);
            }
        }
        return maxOne == null ? Collections.EMPTY_LIST : maxOne.getUrls();
    }

    /**
     * Clean up all the gathered statistics
     * Caution
     */
    public void fullCleanUp() {
        sequenceStatisticsCleanUp();
        user_rs.clear();
        SequenceProducer.cleanUpPool();
    }

    public void sequenceStatisticsCleanUp() {
        seq_counters.clear();
    }

    private final class Sequence {
        // assume page is characterised by url, represent url here as a string
        private List<String> urls;

        private int hashCode;

        Sequence (String url_1, String url_2, String url_3) {
            if (url_1 == null || url_2 == null || url_3 == null
                    || url_1.isEmpty() || url_2.isEmpty() || url_3.isEmpty()) {
                throw  new IllegalArgumentException("Neither of the construction urls allowed to be null or empty");
            }

            // calculate once and keep in this instance. Generally not acceptable, however this class is immutable so it is OK.
            hashCode = url_1.concat(url_2).concat(url_3).hashCode();

            urls = Collections.unmodifiableList(Arrays.asList(new String[]{url_1, url_2, url_3}));
        }

        public String getUrl1() {
            return urls.get(0);
        }
        public String getUrl2() {
            return urls.get(1);
        }
        public String getUrl3() {
            return urls.get(2);
        }
        /**
         * Unmodifiable list of urls, ordered in users' access sequence.
         */
        public List getUrls() {
            return urls;
        }

        public int hashcode() {
            return hashCode;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Sequence))
                return false;

            Sequence seq = (Sequence) o;
            if (!urls.get(0).equals(seq.getUrl1())) {
                return false;
            }
            if (!urls.get(1).equals(seq.getUrl2())) {
                return false;
            }
            if (!urls.get(2).equals(seq.getUrl3())) {
                return false;
            }
            return true;
        }
    }

    // a pool of Sequence instances
    private static final class SequenceProducer {
        /**
         * The pool.
         *
         * Implemented as a HasMap. (Also could be 3D array, but array will need one to one binding contract between url_1..n to index in particular 1D array)
         * There are 8 distinct pages so default load remains and capacity is 12.
         *
         * Map maps sequences [{url1, url2, url8}, {url1, url2, url3}, {url1, url3, url1} {url2, url4, url6}]
         * { url1 -> {
         *              url2 -> {
         *                          url8 -> Sequence(url1, url2, url8)
         *                          url3 -> Sequence(url1, url2, url3)
         *                      }
         *              url3 -> {
         *                          url1 -> Sequence(url1, url3, url1)
         *                      }
         *           }
         *   url2 -> {
         *              url4 -> {
         *                          url1 -> Sequence(url2, url4, url6)
         *                      }
         *           }
         * }
         *
         */
        private static Map<String,Map<String,Map<String, Sequence>>> pool = new HashMap<String, Map<String, Map<String, Sequence>>>(12);

        /** */
        public static Sequence getSequenceFor(String url_1, String url_2, String url_3) {
            // if sequence exists in the pool
            // return it;
            // else
            // create it; Example1: there is no Sequence that starts from url_1 - e.g. pool.get(url_1) == null
            //            Example2: there is Sequence that starts from url_1, but no one that has url_1 followed by url_2 - e.g. pool.get(url_1) != null && pool.get(url_1).get(url_2) == null
            return null;
        }

        public static void cleanUpPool(){
            // cascade clear() over the pool maps
        }
    }
}
