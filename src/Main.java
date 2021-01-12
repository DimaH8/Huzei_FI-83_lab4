
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

        System.out.println();
        System.out.println("A + B");
		temp.Add(A, B);
		System.out.println(temp);

        
        System.out.println();
        System.out.println("A * B");
		temp.Mul(A,B);
		System.out.println(temp);
		
        System.out.println();
        System.out.println("A ^ 2");
		temp.Copy(A);
		temp.Shift_Right();
		System.out.println(temp);
		temp.Null();

		System.out.println();
        System.out.println("A ^ N");
		temp.Pow(A, N);
		System.out.println(temp);
		temp.Null();
		
		
		
		
		System.out.println();
        System.out.println("A ^ (-1):");
        System.out.println();
        temp.Inverse(A);
        System.out.println(temp);
        
		System.out.println();
        System.out.println("A * (A ^ (-1))");
		temp.Mul(A, temp);
		System.out.println(temp);
		temp.Null();

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
