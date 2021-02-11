
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;




public class Main {

    public static Integer sum(Integer n) {
        int sum = 0;
        if (n > 0) {
            for (int i = 0; i <= n; i++) {
                if (i % 5 == 0 || i % 3 == 0) {
                    sum = sum + i;
                }
            }
        }

        return sum;
    }

    public static int search(Integer n, Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            // System.out.println(i);
            if (n.equals(list[i]))
                return i;
        }
        return -1;
    }

    public static int maximum(Integer[] list) {
        Stream<Integer> streamList = Arrays.stream(list);
        int result = streamList.max(Comparator.naturalOrder()).get();
        return result;
    }

    public static int simpleArraySum(int[] arr) {

        IntStream intStream = Arrays.stream(arr);
        return intStream.sum();

    }

    public static long veryBigSum(long[] arr) {

        LongStream longStream = Arrays.stream(arr);
        return longStream.sum();

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int dif = 0;
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            firstDiagonal += arr.get(i).get(i);
            secondDiagonal += arr.get((arr.size() - 1) - i).get(i);
        }
        System.out.println(firstDiagonal);
        System.out.println(secondDiagonal);
        dif = Math.abs(firstDiagonal - secondDiagonal);
        return dif;
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int resultA = 0;
        int resultB = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).compareTo(b.get(i)) > 0) {
                resultA += 1;
            } else if (a.get(i).compareTo(b.get(i)) < 0) {
                resultB += 1;
            }
        }
        return Arrays.asList(resultA, resultB);
    }

    static int sockMerchant(int n, int[] ar) {

        int socketCount = 0;
        int socketMatch = 0;
        int result = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        if (n == ar.length) {
            for (int i = 0; i < ar.length; i++) {

                if (!set.contains(Integer.valueOf(ar[i]))) {
                    set.add(ar[i]);
                    socketCount = 1;
                    for (int j = i + 1; j < ar.length; j++) {
                        if (ar[j] == ar[i])
                            socketCount += 1;
                    }
                    socketMatch = socketCount / 2;
                    result += socketMatch;

                }
            }
        }

        return result;

    }

    public static int getStepValue(char step) {
        if (step == 'D') {
            return -1;
        } else if (step == 'U') {
            return 1;
        }
        return 0;
    }

    public static int countingValleys(int steps, String path) {
        int seaLevel = 0;
        boolean resetSeaLevel = false;
        boolean firstStep = true;
        int sumSteps = 0;
        int valleyCount = 0;

        List<Integer> pathInteger = path.chars().mapToObj(s -> getStepValue((char) s)).collect(Collectors.toList());
        for (Integer step : pathInteger) {
            if (firstStep) {
                if(step > 0 ){
                    resetSeaLevel = true;
                }               
                firstStep = false;
            }
            sumSteps = sumSteps + step;
            if (sumSteps == seaLevel) {
                if (!resetSeaLevel) {
                    valleyCount += 1;
                } else {
                    firstStep = true;
                    resetSeaLevel = false;
                }

            }

        }

        return valleyCount;

    }

    public static String getFizzBuzzValue(Integer n){
        StringBuilder s = new StringBuilder();
        if(n % 3 == 0){
            s.append("Fizz");            
        }
        if (n%5 == 0){
            s.append("Buzz");
        }
        if(s.length()<1){
            s.append(n);
        }
        return s.toString();
    }

    public static void fizzBuzz(int n) {
        if(n>1){
           IntStream.rangeClosed(1, n).boxed().map(num -> getFizzBuzzValue(num)).forEach(System.out::println);
        }
    
        }

        public static int segment(int x, List<Integer> space) {
            int newIndex = 0;
            List<Integer> tmp = null;
            List<Integer> result = new ArrayList<Integer>();
            long startTime = System.nanoTime();

                if(x != space.size()){
                    while(newIndex+x < space.size()){
                        tmp = new ArrayList<Integer>();
                        for(int i=newIndex;i<newIndex+x;i++){
                            tmp.add(space.get(i));
                        }
                        result.add(tmp.stream().min(Comparator.naturalOrder()).get());
                        newIndex++;  
                    }   
                } else{
                    result.add(space.stream().min(Comparator.naturalOrder()).get());
                }                                 

            if(result != null && !result.isEmpty()){
                long stopTime = System.nanoTime();
                System.out.println((stopTime-startTime));
                System.out.println("ms "+(stopTime-startTime)/ 1000000);
                return result.stream().max(Comparator.naturalOrder()).get();
            }                
            else
                return 0;
           
        }

      

    public static void main(String[] args) {
        Integer result = sum(10);
        // System.out.println(result);

        Integer[] list = { 3, 1, 3, 2, 6, 9, 7, 6, 50, 70, 90, 2 };
        Integer[] list2 = { 22, 22, 22, 22 };

        // System.out.println(search(22, list2));

         //System.out.println(maximum(list));

        int[] arr = { 3, 5, 6 };
       // int sumArray = simpleArraySum(arr);
        // System.out.println(sumArray);

        // List<Integer> a = Arrays.asList(17,28,30);
        // List<Integer> b = Arrays.asList(99,16,8);
        // System.out.println(compareTriplets(a,b));

        // long[] arrL = {30000,50000,60000};
        // System.out.println(veryBigSum(arrL));
        List<List<Integer>> dd = Arrays.asList(Arrays.asList(17, 40, 87), Arrays.asList(10, 50, 27),
                Arrays.asList(5, 0, 4));
        // System.out.println(diagonalDifference(dd));

        int[] ar = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
        // System.out.println(sockMerchant(ar.length, ar));

        //System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
       // fizzBuzz(15);

       //List<Integer> space = Arrays.asList(2, 5, 4, 1, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 1,2, 5, 4, 6, 8,2, 5, 4, 1, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,23,8,6,2, 5, 4, 6, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,4,6,2,1,2, 5, 4, 6, 8,2, 5, 4, 6, 8,2, 5, 4, 6, 8,7,2, 5, 4, 6, 8,52, 5, 4, 6, 8,8,2, 5, 4, 6, 8,9,2, 5, 4, 6, 8,4,1,7,5,12,34,7,12,5,7,9,4,2,3,4);
       //List<Integer> space = Arrays.asList(1,2,3,1,2);
       List<Integer> space = new ArrayList<Integer>();
       
       /*  for(int i =0; i<55500; i++){
        int randomInt = (int)(1000.0 * Math.random());
        System.out.println("i : "+i +" - "+ (randomInt+1) );
        space.add(randomInt); */
   // } 
       
      // System.out.println("Min Value "+segment(5,space));
     

       }

}