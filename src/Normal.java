
public class Normal
{
    int n = 233;
    int[] array = new int[n];
    int[][] m = new int[n][n];

    void Matrix()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int a = (TwoToPow(i) + TwoToPow(j)) % (2 * n + 1);
                int b = (TwoToPow(i) - TwoToPow(j)) % (2 * n + 1);
                if (a == 1 || a == 2 * n || b == 1 || b == 2 * n || b == -1 || b == -2 * n)
                {
                    m[i][j] = 1;
                } else
                {
                    m[i][j] = 0;
                }
            }
        }
    }

    String MatrixToString()
    {
        Matrix();
        String out = "";
        for (int i = 0; i < n; i++)
        {
            out += "\r\n";
            for (int j = 0; i < n; i++)
            {
                out += Integer.toString(m[i][j]);
            }
        }
        return out;
    }

    int TwoToPow(int k)
    {
        int m = 2 * n + 1;
        int s = 1, t = 2;

        while (k != 0)
        {
            if ((k & 1) != 0)
            {
                s = (s * t) % m;
            }
            k = k >> 1;
            t = (t * t) % m;
        }
        return s;
    }

    public Normal()
    {
    }

    public Normal(Normal obj)
    {
        this.Copy(obj);
    }

    public Normal(String s)
    {
        Read(s);
    }

    void Copy(Normal obj)
    {
        for (int i = 0; i < n; i++)
            this.array[i] = obj.array[i];
    }

    void Null()
    {
        for (int i = 0; i < n; i++)
            this.array[i] = 0;
    }

    void One()
    {
        for (int i = 0; i < n; i++)
            this.array[i] = 1;
    }

    public String toString()
    {
        String out = "";
        for (int i = 0; i < n; i++)
            out += Integer.toString(array[i]);
        return out;
    }

    void Read(String number_srt)
    {
        if (number_srt.length() > n)
        {
            throw new IllegalArgumentException("Error: Length of input bigger than n");
        }

        char[] temp = new char[n];
        for (int i = 0; i < number_srt.length(); i++)
        {
            char c = number_srt.charAt(i);
            if (c != '0' && c != '1')
            {
                throw new IllegalArgumentException("Error: Unknown char - '" + c + "'");
            }
            temp[i] = c;
        }

        for (int i = 0; i < n; i++)
        {
            if (temp[i] == '0')
                this.array[i] = 0;
            if (temp[i] == '1')
                this.array[i] = 1;
        }
    }

    void Add(Normal add1, Normal add2)
    {
        Normal res = new Normal();

        for (int i = 0; i < n; i++)
        {
            res.array[i] = add1.array[i] ^ add2.array[i];
        }

        this.Copy(res);
    }

    void Shift_Right()
    {
        Normal temp = new Normal();

        for (int i = 0; i < n - 1; i++)
            temp.array[i + 1] = this.array[i];

        temp.array[0] = this.array[n - 1];

        this.Copy(temp);
    }

    void Shift_Left()
    {
        Normal temp = new Normal();
        for (int i = 1; i < n; i++)
            temp.array[i - 1] = this.array[i];

        temp.array[n - 1] = this.array[0];

        this.Copy(temp);
    }

    void Mul(Normal mul1, Normal mul2)
    {
        Matrix();
        Normal mas1 = new Normal(mul1);
        Normal mas2 = new Normal(mul2);
        Normal res = new Normal();
        Normal temp = new Normal();

        for (int i = 0; i < n; i++)
        {
            int s = 0;
            for (int j = 0; j < n; j++)
            {
                s = 0;
                for (int e = 0; e < n; e++)
                { // mul1*matrix
                    s = mas1.array[e] * m[j][e] + s;
                }
                s = s % 2;
                temp.array[j] = s;
            }
            s = 0;
            for (int d = 0; d < n; d++)
            {
                s = temp.array[d] * mas2.array[d] + s;
            }
            s = s % 2;
            res.array[i] = s;

            mas1.Shift_Left();
            mas2.Shift_Left();
        }

        this.Copy(res);
    }

    void Pow(Normal obj, Normal u)
    {
        Normal res = new Normal();
        res.One();

        Normal a = new Normal(obj);
        Normal temp = new Normal();

        for (int i = 0; i < n; i++)
        {
            if (u.array[n - 1 - i] != 0)
            {
                temp.Mul(res, a);
                res.Copy(temp);
                temp.Null();
            }
            a.Shift_Right();
        }

        this.Copy(res);
    }
    
    void Inverse(Normal obj)
	{
    	Normal a = new Normal(obj);
    	Normal u = new Normal();

	    for(int i = 0; i < n-1; i++) {
	        u.array[i] = 1; 
	        }
	     u.array[n-1] = 0;
	
	    this.Pow(a,u);
	}
    
    void Test10 (Normal a, Normal b, Normal c) {
    	Normal result = new Normal();
		this.Add(a, b);
		result.Mul(this, c);
		this.Copy(result);
		
	}

	void Test11 (Normal a, Normal b, Normal c) {
		Normal result = new Normal();
		this.Mul(b, c);
		result.Mul(c, a);
		result.Add(this, result);
		this.Copy(result);	
	}
	
	void Test2 (Normal a, Normal test) {
		this.Pow(a, test);
	}
}
