package lab.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {

	public static void main(String[] args) throws IOException {

		// initializing two files in Array;
		String[] inputFiles = { "/Users/yunya/TEK/slides/303/Week_2/Lab/file1.txt", "/Users/yunya/TEK/slides/303/Week_2/Lab/file2.txt" };
		
		// Specify out file with path location
		// Files contents will be written in these files
		String outputFile = "/Users/yunya/TEK/slides/303/Week_2/Lab/NioOutput.txt";
		
		// Get Channel for destination or outputFile
		FileOutputStream fos = new FileOutputStream(outputFile);
		FileChannel targetChannel = fos.getChannel();
		
		for (int i = 0; i < inputFiles.length; i++) {
			
			// Get channel for inputFiles
			FileInputStream fis = new FileInputStream(inputFiles[i]);
			FileChannel inputchannel = fis.getChannel();
			
			long size = inputchannel.size();
			ByteBuffer buf = ByteBuffer.allocate((int) size);
			System.out.print((char) buf.get());
			
			while (inputchannel.read(buf) > 0) {
				buf.flip();
				while (buf.hasRemaining()) {
					// System.out.print((char) buf.get());
					targetChannel.write(buf);
				}
			}
			// fis.close();
		}

	}

}
