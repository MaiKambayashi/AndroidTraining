package jp.mixi.practice.test.target.test;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import jp.mixi.practice.test.target.TestTarget1;
import jp.mixi.practice.test.target.SubActivity;

public class TestPractice1 extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testStartSubActivity() throws Exception {
        TestTarget1 target = new TestTarget1();
        target.startSubActivity(new TestTarget1Context(getContext()), "hogehoge");
    }
    
    private static class TestTarget1Context extends MockContext{
    	private Context mContext;
    	
    	public TestTarget1Context(Context baseContext){
    		mContext = baseContext;
    	}
    	
    	@Override
    	public String getPackageName(){
    		return mContext.getPackageName();
    	}
    	
    	@Override
    	public void startActivity(Intent intent){
    		ComponentName component = intent.getComponent();
            assertEquals(SubActivity.class.getCanonicalName(), component.getClassName());
            assertEquals(Uri.parse("http://mixi.jp"), intent.getData());
            assertEquals(Intent.FLAG_ACTIVITY_FORWARD_RESULT | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT, intent.getFlags());
            assertTrue(intent.hasExtra(Intent.EXTRA_SUBJECT));
            assertEquals("hogehoge", intent.getStringExtra(Intent.EXTRA_SUBJECT));
    	}
    }
    
    public void testIsValidIntent() throws Exception {
        TestTarget1 target = new TestTarget1();
        Intent intent = new Intent();
        assertFalse(target.isValidIntent(intent));
        intent.putExtra(Intent.EXTRA_TEXT, "mogemoge");
        assertFalse(target.isValidIntent(intent));
        intent.setData(Uri.parse("http://mixi.jp"));
        assertTrue(target.isValidIntent(intent));
    }
}