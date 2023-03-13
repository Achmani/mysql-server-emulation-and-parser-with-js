package id.mit.chrono.server.obj;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CosineSimilarity {

    private Set<Character> unique = new HashSet<>();

    public double score(String a, String b) {

        // store unique char from a
        for (int i = 0; i < a.length(); i++) {
            unique.add(a.charAt(i));
        }

        // store unique char from b
        for (int i = 0; i < b.length(); i++) {
            unique.add(b.charAt(i));
        }

        // char2vec
        int[] vec1 = char2vec(a);
        double vec1Length = Math.sqrt(dotProduct(vec1, vec1));

        int[] vec2 = char2vec(b);
        double vec2Length = Math.sqrt(dotProduct(vec2, vec2));

        // the formula -> Cos(x,y) = x . y / (||x|| * ||y||)
        return dotProduct(vec1, vec2) / (vec1Length * vec2Length);
    }


    // count total char in words -> bag of words
    protected int[] char2vec(String word) {

        int[] vector = new int[unique.size()];

        int index = 0;
        for (Character character : unique) {
            vector[index++] = (int) word.chars().filter(i -> i == character).count();
        }

//        System.out.println("vector: " + Arrays.toString(vector));

        return vector;
    }

    protected double vecLength(int[] vector) {

        int sum = 0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i]^2;
        }

//        System.out.println("sum: " + Math.sqrt(sum));

        return Math.sqrt(sum);
    }

    protected int dotProduct(int[] vector1, int[] vector2) {

        // make sure both vector having same length
        assert vector1.length == vector2.length;

        int dot = 0;
        for (int i = 0; i < vector1.length; i++) {
            dot += vector1[i] * vector2[i];
        }

//        System.out.println("dot product: " + dot);

        return dot;
    }

}
