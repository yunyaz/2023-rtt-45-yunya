package lab.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioTransfer {

	public static void main(String[] args) throws IOException {

		// Input files
		String[] inputFiles = { "/Users/yunya/TEK/slides/303/Week_2/Lab/file1.txt", "/Users/yunya/TEK/slides/303/Week_2/Lab/file2.txt" };
		
		// Files contents will be written in these files
		String outputFile = "/Users/yunya/TEK/slides/303/Week_2/Lab/NioTransfer.txt"; // Get channel for output file
		
		FileOutputStream fos = new FileOutputStream(outputFile);
		WritableByteChannel targetChannel = fos.getChannel();
		
		for (int i = 0; i < inputFiles.length; i++) {
			
			// Get channel for input files
			FileInputStream fis = new FileInputStream(inputFiles[i]);
			FileChannel inputChannel = fis.getChannel();
			
			// Transfer data from input channel to output channel
			inputChannel.transferTo(0, inputChannel.size(), targetChannel);
			
			// close the input channel
			inputChannel.close();
			fis.close();
		}
		// finally close the target channel
		targetChannel.close();
		fos.close();

	}

}
