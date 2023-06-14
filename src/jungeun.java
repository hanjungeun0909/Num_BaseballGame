import java.util.Random;
import java.util.Scanner;
/*컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!
1번째 시도 : 134
0B0S
2번째 시도 : 238
1B1S
3번째 시도 : 820
2B1S
4번째 시도 : 028
3B
5번째 시도 : 280
3S
4번만에 맞히셨습니다.
게임을 종료합니다.*/

public class jungeun {
    public static void main(String[] args){
        // 랜덤한 수 3개 ( 0 ~ 9)
        // 숫자의 값과 위치가 모두 일치하면 S
        // 숫자의 값은 일치하지만 위치가 틀렸으면 B
        // 기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록
        // 숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.
        int[] RA = RandomAnswer();
        System.out.println("생성된 숫자"+RA[0]+RA[1]+RA[2]);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int count = 1;
        while (true){
            int[] UI = UserInput();
            System.out.println(count+"번째 시도 : "+UI[0]+UI[1]+UI[2]);
            int Strike = StrikeBall(RA,UI);
            if (Strike == 3){
                break;
            }
            count++;

        }
        System.out.println(count+"번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");



    }
    // 랜덤값 3자리 생성
    public static int[] RandomAnswer(){
        int[] Answer = new int[3];
        Random rand = new Random();
        do{
            for (int i = 0; i < 3; i++) {
                Answer[i] = rand.nextInt(10);
            }
        }
        while (Answer[0] == Answer[1]||Answer[1] == Answer[2]||Answer[0] == Answer[2]);
//        for (int i = 0; i < 3; i++) {
//            System.out.print(Answer[i]);
//        }
        return Answer;
    }
    // 입력받은 숫자 배열로 저장
    public static int[] UserInput(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] intput = new int[3];
        for (int i = 0; i < 3; i++) {
            intput[i] = Character.getNumericValue(str.charAt(i));
//            System.out.print(intput[i]);
        }
        return intput;
    }
    // strike ball 확인
    public static int StrikeBall(int[] RA, int[] UI){
        int Strike = 0;
        int Ball = 0;
        for (int i = 0; i < 3; i++) {
            if(RA[i] == UI[i]){
                Strike++;
            }
            else{
                for (int j = 0; j < 3; j++) {
                    if (RA[i] == UI[j]){
                        Ball++;
                        }
                    }
                }
            }
        if(Strike== 3){
            System.out.println(Strike+"S");

        } else if (Ball == 3) {
            System.out.println(Ball+"B");

        } else{
            System.out.println(Ball+"B"+Strike+"S");
        }
        return Strike;
        return Strike;
    }
}


