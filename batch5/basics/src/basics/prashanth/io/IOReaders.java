package basics.prashanth.io;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;

public class IOReaders {
	private void stringBufferStream() throws IOException {
		InputStream input = System.in;

		// System.out.println(input.read());

		input = new StringBufferInputStream(
				"sdfsdfdsfsdfdsfds sdfsdfsdfds sdfdsf aa");

		while (input.available() > 0) {
			System.out.print((char) input.read());
		}
	}

	private void fileOutputStreamDemo() throws IOException {

		FileOutputStream out = new FileOutputStream("demo.txt");
		out.write("demo text".getBytes());
	}

	private void fileInputStreamDemo() throws IOException {
		FileInputStream input = null;
		try {
			input = new FileInputStream("demo.txt");
			while (input.available() > 0) {
				System.out.print((char) input.read());
			}
		} finally {
			input.close();
		}

	}

	private void objectOutputStreamDemo() throws IOException {
		FileOutputStream fos = new FileOutputStream("object.data");
		ObjectOutputStream out = new ObjectOutputStream(fos);

		Calculator calc = new Calculator(20, 15);

		out.writeObject(calc);

		fos.close();
		out.close();

	}

	private void objectInputStreamDemo() throws IOException,
			ClassNotFoundException {

		FileInputStream fis = new FileInputStream("object.data");
		ObjectInputStream ios = new ObjectInputStream(fis);

		Calculator calc = (Calculator) ios.readObject();

		System.out.println("the total of addNumbers :" + calc.addNumbers());

	}

	private void bufferedReaderDemo() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String message = br.readLine();
		System.out.println(message);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOReaders ioreaders = new IOReaders();
		ioreaders.fileOutputStreamDemo();
		ioreaders.filInputStreamDemo();

		ioreaders.bufferedReaderDemo();

		ioreaders.objectOutputStreamDemo();
		ioreaders.objectInputStreamDemo();

	}

}