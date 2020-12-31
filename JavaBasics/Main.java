
import java.util.Arrays;
import java.util.Comparator;

import java.util.stream.Stream;

public class Main {
    


        public static Integer sum(Integer n) {
            int sum = 0;
            if(n > 0){
            for(int i=0;i<=n;i++){
                if(i%5 == 0 || i%3==0){
                    sum = sum + i;
                }
            }
            }
            
            return sum;
    }

 
    public static int search(Integer n, Integer[] list) {
        for(int i=0;i<list.length;i++){
           // System.out.println(i);
            if(n.equals(list[i]))
               return i;
        }
        return -1;
    }

    public static int maximum(Integer[] list){
        Stream<Integer> streamList = Arrays.stream(list);
        int result = streamList.max(Comparator.naturalOrder()).get();
        return result;
    }

    public static void main(String[] args) {
        Integer result = sum(10);
        //System.out.println(result);

        Integer[] list ={3, 1, 3, 2, 6, 9, 7, 6,50,70,90,2};
        Integer[] list2 = {22, 22, 22, 22};
        
        //System.out.println(search(22, list2));

        System.out.println(maximum(list));

      
    }

}