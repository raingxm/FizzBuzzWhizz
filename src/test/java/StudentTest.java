import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Equals;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhang on 2014/5/1.
 */
public class StudentTest {
    private Student student;
    private SpecialNums specialNums;
    private GetInput getInput;

    @Before
    public void setUp(){
    }

    @Test
    public void mock_specialNums_get_say_word_return_Fizz() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(9,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{3,5,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("Fizz"));
    }

    @Test
    public void mock_specialNums_get_say_word_return_FizzBuzz() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(18,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{3,9,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("FizzBuzz"));
    }

    @Test
    public void mock_specialNums_get_say_word_return_FizzBuzzWhizz() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(42,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{3,2,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("FizzBuzzWhizz"));
    }

    @Test
    public void mock_specialNums_contains_first_num_return_Fizz() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(30,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{3,6,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("Fizz"));
    }

    @Test
    public void mock_specialNums_get_say_word_return_student_num() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(11,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{3,5,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("11"));
    }

    @Test
    public void mock_specialNums_if_first_special_nums_is_zero() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(100,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{0,2,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("Fizz"));
    }

    @Test
    public void mock_specialNums_if_special_nums_contain_zero() throws Exception{
        specialNums = mock(SpecialNums.class);
        student = new Student(17,specialNums);
        when(specialNums.toNums()).thenReturn(new int[]{5,0,7});
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("17"));
    }

    /**
     * integrate test
     */
    @Test
    public void integrate_test_GetInput_and_SpecialNums_should_work() throws Exception{
        getInput = mock(GetInput.class);
        specialNums = new SpecialNums(getInput);
        student = new Student(32,specialNums);
        when(getInput.getInputString()).thenReturn("2,4,6");
        student.setNums(specialNums.toNums());
        assertThat(student.say(),is("Fizz"));
    }
}
