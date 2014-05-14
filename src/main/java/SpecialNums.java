/**
 * Created by zhangxv on 2014/4/29
 */
public class SpecialNums {
    private GetInput getInput;
    public SpecialNums(GetInput getInput){
        this.getInput = getInput;
    }

    public boolean input_is_valid(String[] sNums){
        if (sNums.length != 3){
            return false;
        }
        for(int i=0;i<sNums.length;i++) {
            if (sNums[i].length() != 1) {
                return false;
            }

            if (sNums[i].charAt(0) < '0' || sNums[i].charAt(0) > '9') {
                return false;
            }

            for(int j=i+1;j<sNums.length;j++){
                if(sNums[i].equals(sNums[j])){
                    return false;
                }
            }
        }

        return true;
    }
    public int[] toNums()throws Exception{
        String input = getInput.getInputString();
        String[] sNums = input.split(",");
        if(!input_is_valid(sNums)){
            return null;
        }
        int[] nums = new int[sNums.length];
        for(int i=0;i<sNums.length;i++){
            nums[i] = Integer.parseInt(sNums[i]);
        }
        return nums;
    }
}
