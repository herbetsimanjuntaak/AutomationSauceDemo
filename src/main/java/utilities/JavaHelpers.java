package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaHelpers {
    private static final Logger log = LoggerFactory.getLogger(JavaHelpers.class);

    //Time-stamps
    /**
     * Get current time-stamp in given format
     * @param format format e.g. "yyyy MMM dd", 'yyyyMMdd_HHmmss' etc.
     * @return String timestamp
     *
     */
    public static String getTimeStamp(String format)
    {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static int getRandomIndex(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        Random random = new Random();
        return random.nextInt(size);
    }

    public static int getRandomIndex(List<?> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }
        return getRandomIndex(list.size());
    }

    /**
     *
     * @param number as string
     * handle empty string will be return 0, string number will be parse to double number, other texts will throw exception
     * @return Double type data
     */
    public static Double convertPriceToDouble(String number) {
        String price = number.replaceAll("\\$", "");
        try {
            if (Objects.equals(price, "")) {
                return 0.0;
            }
            return Double.parseDouble(price);
        } catch (Exception e) {
            log.error("Error when convert value {} to Double, e: {} ", number, e.getMessage());
            throw e;
        }
    }

    /**
     *
     * @param data consist of double value
     * @param sortBy "highest" or "cheapest"
     * @return boolean : if data successfully sorted by param highest/cheapest then would be return true, else return false
     */
    public static Boolean isDataSorted(List<Double> data, String sortBy) {
        Double prevData = data.getFirst();
        for (int i = 1; i < data.size() ; i++) {
            if (!compareDoubleValue(sortBy, prevData, data.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareDoubleValue(String sortBy, Double prevData, Double currentData) {
        if (sortBy.equals("highest")) {
            return prevData > currentData;
        }
        return prevData < currentData;
    }
    public static List<Double> sortPrices(List<Double> prices, boolean ascending) {
        List<Double> sortedPrices = new ArrayList<>(prices);
        if (ascending) {
            Collections.sort(sortedPrices); // Sorting ascending
        } else {
            sortedPrices.sort(Collections.reverseOrder()); // Sorting descending
        }
        return sortedPrices;
    }

}
