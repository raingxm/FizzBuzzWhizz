import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by zhang on 2014/5/1.
 */
public class PlayGame {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Student student;
    private final int TOTAL_STUDENT_NUM = 100;

    public PlayGame(InputStream inputStream,OutputStream outputStream,Student student){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.student = student;
    }

    public void startGame() throws Exception{
        outputStream.write(("欢迎使用FizzBuzzWhizz游戏\n").getBytes());
        int[] nums = null;
        while(nums == null){
            outputStream.write(("请输入三个不同的个位数(使用','分隔):\n").getBytes());
            nums = student.getSpecialNums().toNums();
            if(nums != null){
                student.setNums(nums);
                break;
            }
            outputStream.write(("输入格式不正确!\n").getBytes());
        }

        for(int i=1;i<=TOTAL_STUDENT_NUM;i++){
            student.setStuNum(i);
            outputStream.write((student.say()+"\n").getBytes());
        }

    }

//    public static void main(String[] args) throws Exception{
//        GetInput getInput = new GetInput(System.in);
//        SpecialNums specialNums = new SpecialNums(getInput);
//        Student student = new Student(0,specialNums);
//        PlayGame playGame = new PlayGame(System.in,System.out,student);
//        playGame.startGame();
//    }
}
