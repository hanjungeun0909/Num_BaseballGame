import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Gyuhyeon {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> randomArr = new ArrayList<>();
        while (randomArr.size() < 3){
            int randomNum = (int)(Math.random()*9+1); // 0 ~ 9 사이 랜덤 수
            if (randomArr.contains(randomNum)) continue; // 랜덤 값이 담긴 배열에 현재 랜덤 값이 이미 있을 경우 pass
            else randomArr.add(randomNum); // 배열에 현재 랜덤값이 없을 경우 저장
        }
        System.out.println("정답 : "+ randomArr); // 랜덤 값

        int cnt = 0;

        while (true){
            int strike = 0;
            int ball = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char[] a = br.readLine().toCharArray();
            for (int i=0; i < 3; i++){
                a[i] -= 48;
            }
            int[] arr = new int[3];
            arr[0] = a[0];
            arr[1] = a[1];
            arr[2] = a[2];
            System.out.println(cnt+1+"번째 시도 : "+Arrays.toString(arr)); // 입력 값

            for (int i=0; i < 3; i++){
                if (randomArr.get(i) == arr[i]) strike++;
                else {
                    for (int k=0; k < 3; k++){
                        if (randomArr.get(i) == arr[k]) ball++;
                    }
                }
            }
            cnt++;
            System.out.println(ball+"B"+strike+"S");

            if (strike == 3) {
                System.out.println(cnt+"번만에 맞히셨습니다!");
                System.out.println("게임을 종료합니다!");
                break;
            }
        }
    }
}