package com.snc.sharenote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 단지번호붙이
 */
public class Number2667 {

    //오, 왼, 위, 아래
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static int[][] map; //입력받은 값
    private static int[] result;    //결과(단지수, 집의수)

    private static int N;

    /**
     * 7
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     *
     * @return
     */
    public int[] test() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char num = line.charAt(j);
                map[i][j] = num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(map[i][j]);
            }
        }

        return result;
    }


    public int[] test(File problemFile) throws IOException {
        FileReader fileReader = new FileReader(problemFile);
        int singleCh = 0;
        StringBuilder problemBuilder = new StringBuilder();
        while ((singleCh = fileReader.read()) != -1) {
            problemBuilder.append((char) singleCh);
        }
        fileReader.close();

        String problem = problemBuilder.toString();
        String[] lines = problem.split("\n");
        N = Integer.parseInt(lines[0]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = lines[i + 1].charAt(j);
                map[i][j] = Integer.parseInt(String.valueOf(num));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        return result;
    }
}
