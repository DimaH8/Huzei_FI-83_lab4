
public class Main {

	public static void main(String[] args) {
		Normal A = new Normal("11101100010010101011010011110001010100011011101010011101000111001111101110101101110110001001000100110110111010001001011011001101011011001001001010101011011100101000101111001001001111111111011110101101010010101111111011111010001010100");
        Normal B = new Normal("00100100000000011000001100110001000001010010001010010101011000110011001111111110100000101011010111001100111001100000110111100010110001111111111100001110110011111100100110100111100101111000110111111001110100110111111010000110011101001");
        Normal N = new Normal("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Normal C = new Normal("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Normal Test = new Normal("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		Normal temp = new Normal();

        System.out.println("Polinom A");
        System.out.println(A);
        System.out.println("Polinom B");    
        System.out.println(B);
        System.out.println("Polinom N");            
        System.out.println(N);
        
        long avTime = 0;
		String str = "";
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			temp.Add(A, B);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			str = temp.toString();
			temp.Null();
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println();
		System.out.println("A + B: ");
		System.out.println(str);
		System.out.println("Time of work <A + B> is: " + avTime);
		avTime = 0;	
		str = "";
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			temp.Mul(A, B);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			str = temp.toString();
			temp.Null();
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println("A * B: ");
		System.out.println(str);
		System.out.println("Time of work <A * B> is: " + avTime);
		avTime = 0;	
		str = "";

		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			temp.Copy(A);
			temp.Shift_Right();
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			str = temp.toString();
			temp.Null();
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println("A ^ 2:");
		System.out.println(str);
		System.out.println("Time of work <A ^ 2> is: " + avTime);
		avTime = 0;	
		str = "";
	
		for (int j = 0; j < 10; j++) {
			long startTime = System.nanoTime();

			temp.Inverse(A);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			str = temp.toString();
			temp.Null();
		}
		avTime = avTime/10;
		System.out.println();
		System.out.println("A ^ (-1):");
		System.out.println(str);
		System.out.println("Time of work <A ^ (-1)> is: " + avTime);
		avTime = 0;	
		str = "";

		for (int j = 0; j < 30; j++) {
			long startTime = System.nanoTime();

			temp.Pow(A, N);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			str = temp.toString();
			temp.Null();
		}
		avTime = avTime/30;
		System.out.println();
		System.out.println("A ^ N:");
		System.out.println(str);
		System.out.println("Time of work <A ^ N> is: " + avTime);
		avTime = 0;	
		str = "";
        
        
        System.out.println();
        System.out.println();
        System.out.println("(a + b)*c:");
        System.out.println();
        temp.Test10(A ,B, C);
        System.out.println(temp);
		
        System.out.println();
        System.out.println("b*c + c*a:");
        System.out.println();
        temp.Test11(A ,B, C);
        System.out.println(temp);
		

        System.out.println();
        System.out.println("d^(2^m - 1):");
        System.out.println();
		temp.Test2(A, Test);
		System.out.println(temp);
		
		

	}

}
