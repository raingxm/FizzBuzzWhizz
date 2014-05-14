import java.io.InputStream;

/**
 * Created by zhangxv on 2014/4/29
 */
public class GetInput {
    private InputStream inputStream;
    public GetInput(InputStream inputStream){
        this.inputStream = inputStream;
    }
    public String getInputString() throws Exception{
        byte[] input = new byte[1024];
        inputStream.read(input);
        return new String(input).trim();
    }
}
