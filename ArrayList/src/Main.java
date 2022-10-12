import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> animals = new ArrayList<>();
		
		String cat = "고양이";
		String dog = "개";
		String lion = "사자";
		
		
		animals.add(cat);
		animals.add(dog);
		animals.add(lion);
		
		System.out.println(animals.get(0));
		System.out.println(animals.get(1));
		System.out.println(animals.get(2));
		System.out.println("데이터수:" + animals.size());
		for(int i=0; i<3; i++) {
			System.out.println(animals.get(i));
		}
		System.out.println("============================");
		
		animals.remove(1);
		System.out.println("데이터수:" + animals.size());
		for(int i =0; i<2; i++) {
			System.out.println(animals.get(i));
		}
		System.out.println("============================");
		
		animals.clear();
		System.out.println("데이터수:" + animals.size());
	}

}
