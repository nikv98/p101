import java.util.ArrayList;

public class Driver {
	private static ArrayList arr;
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		printMe();
		
		int x = 5;
		String str = "Hello World";
		//in C++ this would be cout << "Hello World" << x << endl;
		System.out.println(str + " " + x);
	}

	public static void printMe(){
		arr = new ArrayList();
		for(int someNum = 0; someNum < 10; someNum++){
			arr.add(someNum);
		}
		System.out.println(arr);
		arr.remove(arr.size()-1);
		System.out.println(arr);
	}
}

