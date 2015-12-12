/**
 * 
 */
package com.hadoop.mapreduce.test;

import java.io.IOException;

import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.mapReduce.WordMapper;

/**
 * @author admin
 *
 */
public class WordMapperTest {
	
	MapDriver<Text, Text, Text, Text> mapDriver;
	
	@Before
	public void setup(){
		WordMapper mapper = new WordMapper();
		mapDriver = MapDriver.newMapDriver(mapper);
	}
	
	@Test
	public void processValidRecord() throws IOException{
		
		mapDriver.withInput(new Text("a"), new Text("ein"));
		mapDriver.withInput(new Text("a"), new Text("zwei"));
		mapDriver.withInput(new Text("c"), new Text("drei"));
		mapDriver.withOutput(new Text("a"), new Text("ein"));
		mapDriver.withOutput(new Text("a"), new Text("zwei"));
		mapDriver.withOutput(new Text("c"), new Text("drei"));
		mapDriver.runTest();
	}

}
