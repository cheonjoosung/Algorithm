package grammer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOExample {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		FileInputStream fis = null;;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("src/test/Test.java");
			fos = new FileOutputStream("src/test/Byte.txt"); 

			int readCount = -1; //한바이트씩 
			byte[] buffer = new byte[512]; //512바이트씩

			while((readCount = fis.read()) != -1) {
				fos.write(buffer, 0 , readCount);
				fos.write(readCount);
			}
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {				
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();
		System.out.println(end-start);

		/*
		 * Close 없이 자동으로 호출하는 try-with (io 선언) { } catch 
		 */
		try (
				DataOutputStream out = 
				new DataOutputStream(new FileOutputStream("src/grammer/data.txt"));
				) {
			out.writeInt(100); //4byte
			out.writeBoolean(true); //1byte
			out.writeDouble(50.0); //8byte
		} catch(Exception e) {
			e.printStackTrace();
		}

		try (
				DataInputStream in = 
				new DataInputStream(new FileInputStream("src/grammer/data.txt"));
				) {
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();

			System.out.println(i + " " + b + " " + d);
		} catch(Exception e) {
			e.printStackTrace();
		}

		/*
		 * Char Buffer 
		 * Decoratoer 객체에 추가적인 요건을 동적으로 첨가하는 방식. 서브클래스를 만드는 것을 통해 기능을 유연하게 확장
		 */
		PrintWriter pw = null;
		try {
			BufferedReader br =
					new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br2 = 
					new BufferedReader(new FileReader("src/grammer/data.txt"));
			pw = new PrintWriter(new FileWriter("src/grammer/test.txt"));
			String line = null;

			while((line = br.readLine()) != null) {
				pw.println(line);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			pw.close();
		}















	}
}
