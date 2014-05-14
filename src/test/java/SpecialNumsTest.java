import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhangxv on 2014/4/29
 */
public class SpecialNumsTest {
    private SpecialNums specialNums;
    private  GetInput getInput;
    @Before
    public void setup(){
        getInput = mock(GetInput.class);
        specialNums = new SpecialNums(getInput);
    }

    @Test
    public void should_have_three_numbers() throws Exception{
        when(getInput.getInputString()).thenReturn("2,3,4");
        int[] nums = specialNums.toNums();
        assertThat(nums.length,is(3));
    }

    @Test
    public void should_not_have_same_numbers() throws Exception{
        when(getInput.getInputString()).thenReturn("2,2,3");
        int[] nums = specialNums.toNums();
        assertThat(nums,nullValue());
    }

    @Test
    public void if_invalid_input_return_null() throws Exception{
        when(getInput.getInputString()).thenReturn("2,1,a");
        int[] nums = specialNums.toNums();
        assertThat(nums, nullValue());
    }

    @Test
    public void if_invalid_input_not_has_number_return_null() throws Exception{
        when(getInput.getInputString()).thenReturn(",,");
        int[] nums = specialNums.toNums();
        assertThat(nums, nullValue());
    }
}
