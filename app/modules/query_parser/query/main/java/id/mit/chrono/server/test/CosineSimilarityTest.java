package id.mit.chrono.server.test;

import id.mit.chrono.server.obj.CosineSimilarity;

import java.util.Scanner;

public class CosineSimilarityTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("input 1st string: ");
        String s1 = scanner.nextLine();

        System.out.print("input 2nd string: ");
        String s2 = scanner.nextLine();

        CosineSimilarity cosine = new CosineSimilarity();
        double score = cosine.score(s1, s2);

        System.out.println("similarity score: " + score);
    }

}
