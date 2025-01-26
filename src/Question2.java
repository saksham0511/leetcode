import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] array = new int[]{2,3,1,1,4};
        String s = "leetcode";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(2);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);


    }
    static class Solution {

    }
}
