
public class StringParse {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tres = "Hello, my name is John, or at least I think so";
		String[] hello = new String [3];
		hello = tres.split(",");
		for(int i = 0; i<hello.length;i++){
			System.out.println(hello[i]);
		}
		
		
	}

}
