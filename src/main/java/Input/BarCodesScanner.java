package Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BarCodesScanner {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String scanBarCode() throws Exception {
        return br.readLine();
    }
}
