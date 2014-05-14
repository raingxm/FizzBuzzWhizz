import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.*;

/**
 * Created by zhang on 2014/5/1.
 */
public class PlayGameTest {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Student student;
    private PlayGame playGame;

    @Before
    public void setUp(){
        inputStream = mock(InputStream.class);
        outputStream = mock(OutputStream.class);
        student = mock(Student.class);
        playGame = new PlayGame(inputStream,outputStream,student);
    }

    @Test
    public void when_start_game_print_messages() throws Exception{
        SpecialNums specialNums = mock(SpecialNums.class);
        when(specialNums.toNums()).thenReturn(new int[]{2,3,6});
        when(student.getSpecialNums()).thenReturn(specialNums);
        playGame.startGame();
        verify(outputStream).write(("欢迎使用FizzBuzzWhizz游戏\n").getBytes());
        verify(outputStream).write(("请输入三个不同的个位数(使用','分隔):\n").getBytes());
    }

    @Test
    public void when_start_game_input_invalid_print_error_message() throws Exception{
        SpecialNums specialNums = mock(SpecialNums.class);
        when(specialNums.toNums()).thenReturn(null).thenReturn(new int[]{2,3,6});
        when(student.getSpecialNums()).thenReturn(specialNums);
        playGame.startGame();
        verify(outputStream).write(("欢迎使用FizzBuzzWhizz游戏\n").getBytes());
        verify(outputStream).write(("输入格式不正确!\n").getBytes());
    }


    @Test
    public void when_start_game_student_say_words() throws Exception{
        SpecialNums specialNums = mock(SpecialNums.class);
        when(specialNums.toNums()).thenReturn(new int[]{3,5,6});
        when(student.getSpecialNums()).thenReturn(specialNums);
        when(student.say()).thenReturn("1");
        playGame.startGame();
        verify(outputStream).write(("欢迎使用FizzBuzzWhizz游戏\n").getBytes());
        verify(outputStream).write(("请输入三个不同的个位数(使用','分隔):\n").getBytes());
        verify(outputStream,times(100)).write(("1"+"\n").getBytes());

    }

    @Test
    public void integrate_test() throws Exception{
        GetInput getinput = mock(GetInput.class);
        SpecialNums specialNums= new SpecialNums(getinput);
        Student stu = new Student(0,specialNums);
        playGame = new PlayGame(inputStream,outputStream,stu);
        when(getinput.getInputString()).thenReturn("3,5,7");
        playGame.startGame();
        verify(outputStream).write(("欢迎使用FizzBuzzWhizz游戏\n").getBytes());
        verify(outputStream).write(("请输入三个不同的个位数(使用','分隔):\n").getBytes());
        verify(outputStream).write(("1"+"\n").getBytes());
        verify(outputStream,times(37)).write(("Fizz"+"\n").getBytes());
        verify(outputStream,times(5)).write(("FizzBuzz"+"\n").getBytes());
        verify(outputStream,never()).write(("FizzBuzzWhizz"+"\n").getBytes());
    }

}
