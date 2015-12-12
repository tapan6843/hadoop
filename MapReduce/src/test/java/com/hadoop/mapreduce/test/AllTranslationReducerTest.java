/**
 * 
 */
package com.hadoop.mapreduce.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.mapReduce.AllTranslationsReducer;

/**
 * @author admin
 *
 */
public class AllTranslationReducerTest {

	ReduceDriver<Text, Text, Text, Text> reduceDriver;

	@Before
	public void setUp() {
		AllTranslationsReducer reducer = new AllTranslationsReducer();
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
	}

	@Test
	public void processReducer() throws IOException {
		List<Text> values = new ArrayList<Text>();
		values.add(new Text("ein"));
		values.add(new Text("zwei"));
		reduceDriver.withInput(new Text("a"), values);
		reduceDriver.withOutput(new Text("a"), new Text("|ein|zwei"));
		reduceDriver.runTest();
	}
}
