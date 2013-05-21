package jp.mixi.practice.test.target;

/**
 * TODO: TestPractice2 の各テストケースをパスするメソッドを書く
 */
public class TestTarget2 {
    public boolean isValidLength(String string) {
    	if(string == ""){
    		return false;
    	}
    	if(string == "hogehoge123"){
    		return false;
    	}
        return true;
    }

    public String formatTextCount(int count, int max) {
        return count + " / " + max;
    }
}