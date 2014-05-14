/**
 * Created by zhangxv on 2014/4/30
 */
public class Student {
    private int stuNum;
    private final String[] words = new String[]{"Fizz","Buzz","Whizz"};
    private SpecialNums specialNums;
    private int[] nums;

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public SpecialNums getSpecialNums() {
        return specialNums;
    }

    public Student(int stuNum,SpecialNums specialNums){
        this.stuNum = stuNum;
        this.specialNums = specialNums;
    }

    public void setStuNum(int stuNum){
        this.stuNum = stuNum;
    }

    public int get_zero_index(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                return i;
            }
        }

        return -1;
    }

    public String say() throws Exception{
        String sayWords = "";
        int zeroIndex = get_zero_index(nums);
        for(int i=0;i<nums.length;i++){
            if(i ==0 && (stuNum+"").contains(nums[i]+"")){
                return words[i];
            }

            if(zeroIndex == i){
                break;
            }

            if(stuNum%nums[i] == 0){
                sayWords += words[i];
            }
        }

        if(sayWords.equals("")){
            sayWords = stuNum+"";
        }
        return sayWords;
    }
}
