package p1;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class allureListner extends Base  implements ITestListener{
	



	//--------------------------------------------
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		takeScreentshot("this SC shoot from Listeners onTestSuccess");
		takeScreentshot("this SC shoot from Listeners onTestSuccess");
		System.out.println("Test Passed With the name : " +result.getName());
		//screenshot();//not working idk why
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		takeScreentshot("this SC shoot from Listeners onTestFailure");
		//screenshot();//not working idk why
		System.out.println("Test Failed With the name : " +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		takeScreentshot("this SC shoot from Listeners onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


}
