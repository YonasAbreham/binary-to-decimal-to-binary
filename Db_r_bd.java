

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Db_r_bd
{
    public void D_to_B(int decimalno)
    {
        int[] binary = new int[1000000];
        int index = 0;

        while (decimalno > 0)
        {
            binary[index++] = decimalno % 2;
            decimalno = decimalno / 2;
        }

        rev(binary, index);
        
//display 1011

    }
 
    public void rev(int[] itm, int index)
    {
        int[] reversed = new int[index]; // <- store the reversed here


        for (int j = 0; j < index; j++) // <- Start reversed loop
        {
            reversed[index - j - 1] = itm[j]; // <- save it here
        }

        System.out.print(B_to_D(reversed));
    }
    
    public int B_to_D(int bno[])
    {
        int decimal = 0;
        int power = 0;

        for (int i = 0; i < bno.length; i++)
        {
            int temp = bno[i] % 10;
            decimal += temp * Math.pow(2, power);
            power++;
            bno[i] = bno[i] / 10;
        }

        return decimal;
    }

    public static void main(String args[])
    {
        Db_r_bd obj = new Db_r_bd();

        Kattio io = new Kattio(System.in, System.out);
        int d = io.getInt();
        obj.D_to_B(d);
    }
    
    static class Kattio extends PrintWriter
    {
        public Kattio(InputStream i)
        {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o)
        {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens()
        {
            return peekToken() != null;
        }

        public int getInt()
        {
            return Integer.parseInt(nextToken());
        }

        public double getDouble()
        {
            return Double.parseDouble(nextToken());
        }

        public long getLong()
        {
            return Long.parseLong(nextToken());
        }

        public String getWord()
        {
            return nextToken();
        }

        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken()
        {
            if (token == null)
            {
                try
                {
                    while (st == null || !st.hasMoreTokens())
                    {
                        line = r.readLine();

                        if (line == null)
                            return null;

                        st = new StringTokenizer(line);
                    }

                    token = st.nextToken();

                }
                catch (IOException e)
                {
                }
            }

            return token;
        }

        private String nextToken()
        {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}
